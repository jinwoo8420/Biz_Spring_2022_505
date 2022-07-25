package com.callor.naver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EncycVO {
	private String title; // string 검색 결과 사전 정의의 제목을 나타낸다.
	private String link; // string 사전 정의 정보 및 추가 정보를 볼 수 있는 link를 제공한다. link값은 두산 백과사전 사이트의 해당 페이지로 연결된다.
	private String description; // string 검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와
								// 일치하는 부분은 태그로 감싸져 있다.
	private String thumbnail; // string 검색 결과에 이미지가 포함된 경우, 해당 이미지의 썸네일 link url을 나타낸다.
	private String e_seq;
	private String e_username;
}
