package com.callor.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.UserVO;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController {

	// UserService interface를 상속받은 어떤 클래스를 주입받겠다는 선언
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("LAYOUT", "JOIN");

		return "home";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("회원정보 : {}", userVO.toString());
		
		userService.join(userVO);

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("LAYOUT", "LOGIN");

		return "home";
	}

}
