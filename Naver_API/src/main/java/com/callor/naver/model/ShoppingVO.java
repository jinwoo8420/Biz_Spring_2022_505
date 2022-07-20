package com.callor.naver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ShoppingVO {
	private String title; //	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
	private String link; //	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
	private String image; //	string	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
	private String lprice; //	integer	최저가 정보이다. 최저가 정보가 없는 경우 0으로 표시되며, 가격비교 데이터가 없는 경우 이 필드는 가격을 나타낸다.
	private String hprice; //	integer	최고가 정보이다. 최고가 정보가 없거나 가격비교 데이터가 없는 경우 0으로 표시된다.
	private String mallName; //	string	상품을 판매하는 쇼핑몰의 상호이다. 정보가 없을 경우 네이버로 표기된다.
//	private String productId; //	integer	해당 상품에 대한 ID 이다.
	private String maker; //	string	해당 상품의 제조사 명이다.
	private String brand; //	string	해당 상품의 브랜드 명이다.
	private String s_seq;
	private String s_username;
}
