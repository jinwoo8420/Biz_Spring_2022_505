package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "user/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("JOIN {}", userVO);

		return "redirect:/";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage() {

		return "user/mypage";
	}

}
