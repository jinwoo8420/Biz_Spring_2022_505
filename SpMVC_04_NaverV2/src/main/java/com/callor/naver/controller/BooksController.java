package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/books")
@Controller
public class BooksController {
	/*
	 * return 문자열 형식은
	 * 명시적으로 어떤 jsp 파일을 rendering 할 것인지 알려주는것
	 * 현재 method를 요청한 URL에 대하여  jsp를 명시적 전달
	 * 
	 * return null 형식은
	 * 암시적으로 어떤 jsp 파일을 rendering 할 것인지 알려주는 것
	 * 현재 method를 요청한 URL이 명시적으로 명확 할 경우
	 * null을 return 하면 Spring에서 자체적으로 폴더 / 파일 형식으로 구성
	 */
	
	/*
	 * 프로젝트의 요청에 대하여 소수의 Controller를 만들고 처리 가능
	 * 하지만 프로젝트 규모가 커지면 코드 관리가 어려워지고
	 * 결국에는 프로젝트를 Refactoring 해야 됨
	 */

	@RequestMapping(value = "/list")
	public String list() {
		return "books/list";
	}
}
