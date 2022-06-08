package com.callor.naver.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.config.QualifierConfig;
import com.callor.naver.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.NAVER_V0)
public class NaverServiceImpl implements NaverService {
	protected String cat = "BOOK";

	/*
	 *  cat과 search에 담긴 값을 전달받아서
	 *  Naver에 요청 할 QueryString을 생성하는 method
	 */

	public String queryString(String cat, String search) {
		this.cat = cat;

		String queryString = NaverConfig.NAVER_BOOK_URL;

		if (cat.equals("NEWS")) {
			queryString = NaverConfig.NAVER_NEWS_URL;
		} else if (cat.equals("MOVIE")) {
			queryString = NaverConfig.NAVER_MOVIE_URL;
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

	// queryString을 전달받아 Naver에 데이터를 요청하고 응답받은 JSON String을 return 하기
	public String getJsonString(String queryString) {
		URL url = null; // java.net.URL을 import

		HttpsURLConnection httpCon = null;

		try {
			// queryString(URL, 요청정보)를 사용하여 Network를 통해서 보낼 데이터 생성
			url = new URL(queryString);
			httpCon = (HttpsURLConnection) url.openConnection();

			httpCon.setRequestMethod("GET"); // GET 방식으로 요청

			httpCon.setRequestProperty(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
			httpCon.setRequestProperty(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);

			// Naver에게 queryString 정보를 보내고 response 해줄 데이터가 있는지 먼저 확인
			int resCode = httpCon.getResponseCode();

			InputStreamReader is = null;
			BufferedReader buffer = null;

			if (resCode == 200) { // Naver가 200 코드를 보내면
				is = new InputStreamReader(httpCon.getInputStream()); // 데이터를 받아올 통로 연결
			} else { // 만약 200 코드가 아니면
				is = new InputStreamReader(httpCon.getErrorStream()); // 오류 메시지를 받은 통로 연결
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
		// TODO Auto-generated method stub
		return null;
	}

}
