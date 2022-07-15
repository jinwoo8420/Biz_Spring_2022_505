package com.callor.naver.service.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import com.callor.naver.config.NaverConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NaverMovieServiceEx {

	public String queryString(String cat, String search) {
		String queryString = NaverConfig.NAVER_MOVIE_URL;
		String encodeSearch = null;

		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류 발생");

			return null;
		}

		queryString += String.format("?query=%s", encodeSearch);
		log.debug("Query : " + queryString);

		queryString += String.format("&display=%d", 20);

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

}
