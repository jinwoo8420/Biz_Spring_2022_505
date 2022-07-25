package com.callor.naver.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.EncycVO;
import com.callor.naver.model.MovieVO;
import com.callor.naver.model.NaverParent;
import com.callor.naver.model.ShoppingVO;
import com.callor.naver.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImpl implements NaverService {
	protected String cat = "BOOK";

	public String queryString(String cat, String search) {
		this.cat = cat;

		String queryString = NaverConfig.NAVER_BOOK_URL;

		if (cat.equals("SHOPPING")) {
			queryString = NaverConfig.NAVER_SHOPPING_URL;
		} else if (cat.equals("MOVIE")) {
			queryString = NaverConfig.NAVER_MOVIE_URL;
		} else if (cat.equals("ENCYC")) {
			queryString = NaverConfig.NAVER_ENCYC_URL;
		}

		String encodeSearch = null;

		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류 발생");

			return null;
		}

		queryString += String.format("?query=%s", encodeSearch);
		log.debug("Query : " + queryString);

		queryString += String.format("&display=%d", 10);

		return queryString;
	} // end queryString()

	public String getJsonString(String queryString) {
		URL url = null;

		HttpsURLConnection httpCon = null;

		try {
			url = new URL(queryString);
			httpCon = (HttpsURLConnection) url.openConnection();

			httpCon.setRequestMethod("GET");

			httpCon.setRequestProperty(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
			httpCon.setRequestProperty(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);

			int resCode = httpCon.getResponseCode();

			InputStreamReader is = null;
			BufferedReader buffer = null;

			if (resCode == 200) {
				is = new InputStreamReader(httpCon.getInputStream());
			} else {
				is = new InputStreamReader(httpCon.getErrorStream());
			}

			buffer = new BufferedReader(is);

			String retString = "";

			while (true) {
				String line = buffer.readLine();

				if (line == null)
					break;

				retString += line;
			}

			return retString;

		} catch (MalformedURLException e) {
			log.debug("Query String 문자열 오류");
			return null;
		} catch (IOException e) {
			log.debug("네트워크 연결 불가");
			return null;
		}
	}

	@Override
	public List<Object> getNaver(String queryString) {
		URI restURI = null;

		try {
			restURI = new URI(queryString);
		} catch (URISyntaxException e) {
			log.debug("URI 문법오류");
			return null;
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
		headers.set(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

		RestTemplate restTemp = new RestTemplate();

		if (cat.equals("BOOK")) {
			ResponseEntity<NaverParent<BookVO>> resData = null;

			resData = restTemp.exchange(restURI, HttpMethod.GET, entity,
					new ParameterizedTypeReference<NaverParent<BookVO>>() {
					});

			return resData.getBody().items;
		} else if (cat.equals("SHOPPING")) {
			ResponseEntity<NaverParent<ShoppingVO>> resData = null;

			resData = restTemp.exchange(restURI, HttpMethod.GET, entity,
					new ParameterizedTypeReference<NaverParent<ShoppingVO>>() {
					});

			return resData.getBody().items;
		} else if (cat.equals("MOVIE")) {
			ResponseEntity<NaverParent<MovieVO>> resData = null;

			resData = restTemp.exchange(restURI, HttpMethod.GET, entity,
					new ParameterizedTypeReference<NaverParent<MovieVO>>() {
					});

			return resData.getBody().items;
		} else if (cat.equals("ENCYC")) {
			ResponseEntity<NaverParent<EncycVO>> resData = null;

			resData = restTemp.exchange(restURI, HttpMethod.GET, entity,
					new ParameterizedTypeReference<NaverParent<EncycVO>>() {
					});

			return resData.getBody().items;
		}

		return null;
	}

}
