package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/news")
@Controller
public class NewsController {

	@RequestMapping(value = "/news_list")
	public String news_list() {
		return "news/news_list";
	}
}
