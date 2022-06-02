package com.callor.naver.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

		/*
		 * NaverParent는 List<VO> 타입의 items 변수를 갖는데
		 * 여기에서 VO type을 BookVO로 확정지어준다
		 */

		ResponseEntity<NaverParent<BookVO>> resData = null;
		RestTemplate restTemp = new RestTemplate();

//		resData = restTemp.exchange(restURI, HttpMethod.GET, entity, NaverParent<BookVO>);

		/*
		 * Naver 에서 받은 데이터는 resData 의 body 에 담겨있다
		 * body 데이터를 get 하여 그 데이터중에서 items 만 추출하여
		 * Controller 로 return
		 */

		return resData.getBody().items;
	}

}
