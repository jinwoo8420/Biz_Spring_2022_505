package com.callor.naver.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.service.exec.NaverBookServiceEx;
import com.callor.naver.service.exec.NaverShoppingServiceEx;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

//	@ResponseBody
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String b_home(String title, Model model) {
//		NaverBookServiceEx naverService = new NaverBookServiceEx();
//		String queryString = naverService.queryString("BOOK", title);
//		String resString = naverService.getJsonString(queryString);
//
//		return resString;
//	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String s_home(String title, Model model) {
		NaverShoppingServiceEx naverService = new NaverShoppingServiceEx();
		String queryString = naverService.queryString("SHOPPING", title);
		String resString = naverService.getJsonString(queryString);

		return resString;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String m_home(String title, Model model) {
//		NaverBookServiceEx naverService = new NaverBookServiceEx();
//		String queryString = naverService.queryString("BOOK", title);
//		String resString = naverService.getJsonString(queryString);
//
//		return resString;
//	}

}
