package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/movies")
@Controller
public class MoviesController {

	@RequestMapping(value = { "/", "" })
	public String movies_list() {
		return "movies/movies_list";
	}
}
