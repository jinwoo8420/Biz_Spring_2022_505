package com.callor.naver.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.NaverParent;
import com.callor.naver.service.NaverService;
import com.callor.naver.service.exec.NaverBookServiceEx;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImplV1 extends NaverBookServiceEx implements NaverService {

	@Override
	public List<BookVO> getNaverBook(String queryString) {
		URI restURI = null;

		try {
			restURI = new URI(queryString);
		} catch (URISyntaxException e) {
			log.debug("URI 문법오류");
			return null;
		}

		// Http 프로토콜에 보안 정보를 세팅하여 Naver로 전송 할 준비
		HttpHeaders headers = new HttpHeaders();
		headers.set(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
		headers.set(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);

		// JSON 데이터 타입으로 받음
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// headers에 추가된 정보를 Entity type의 객체로 변환하기
		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

		ResponseEntity<NaverParent> resData = null;
		RestTemplate restTemp = new RestTemplate();

		resData = restTemp.exchange(restURI, HttpMethod.GET, entity, NaverParent.class);

		return resData.getBody().items;
	}

}
