package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.insert(userVO);

		return "redirect:/login";
	}

	/*
	 * method 수준에서 권한 살펴보기
	 */
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Principal principal) {
		/*
		 * Security에서 로그인한 username은 Principal 객체에 담겨있다
		 */

		String username = principal.getName();

		return "user/mypage";
	}

	/*
	 * @AuthenticationPrincipal
	 * UserVO 클래스 앞에 붙이면
	 * 로그인한 사용자 정보를 객체에 담아준다
	 */

	@RequestMapping(value = "/mypage2", method = RequestMethod.GET)
	public String mypage(@AuthenticationPrincipal UserVO userVO) {

		return "user/mypage";
	}
}
