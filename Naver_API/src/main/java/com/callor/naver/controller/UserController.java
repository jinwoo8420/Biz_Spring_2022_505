package com.callor.naver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.model.UserVO;
import com.callor.naver.service.UserService;

@RequestMapping(value = "/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("LAYOUT", "JOIN");

		return "home";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.join(userVO);

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error) {
		model.addAttribute("LAYOUT", "LOGIN");

		model.addAttribute("error", error);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, UserVO userVO) {
		UserVO loginUser = userService.findById(userVO.getUsername());

		if (loginUser == null) {
			model.addAttribute("error", "USERNAME_FAIL");
			return "redirect:/user/login";
		}

		loginUser = userService.login(userVO);

		if (loginUser == null) {
			model.addAttribute("error", "PASSWORD_FAIL");
			return "redirect:/user/login";
		}

		session.setAttribute("USER", loginUser);

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");

		return "redirect:/";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("USER");

		if (loginUser == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		model.addAttribute("LAYOUT", "MYPAGE");

		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/idcheck/{username}", method = RequestMethod.GET)
	public String idcheck(@PathVariable("username") String username) {
		UserVO userVO = userService.findById(username);

		if (userVO == null) {
			return "OK";
		}

		return "FAIL";
	}

	@ResponseBody
	@RequestMapping(value = "/emailcheck", method = RequestMethod.GET)
	public String emailcheck(String email) {
		UserVO userVO = userService.findByEmail(email);

		if (userVO == null) {
			return "OK";
		}

		return "FAIL";
	}

}
