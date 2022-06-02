package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/member")
@Controller
public class MemberController {

	@RequestMapping(value = "/login")
	public String login() {
		return null;
	}

	@RequestMapping(value = "/join")
	public String join() {
		return null;
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return null;
	}

//	@RequestMapping(value = "/mypage")
//	public String mypage() {
//		return null;
//	}

}
