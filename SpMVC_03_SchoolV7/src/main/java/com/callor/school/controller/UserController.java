package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequestMapping(value = "/user")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}

	/*
	 * 1. login.form에서 username과 password 받기
	 * 2. userVO에 담겨서 받게 된다
	 * 3. userVO UserService.login에게 전달한다
	 * 4. UserService.login() method는 username과 password 검사
	 * 5. 정상적인(username, password가 일치) 정보이면
	 * 		나머지 user 정보를 userVO에 담아서 return
	 *  	만약 정상적인 사용자가 아니면 null을 return
	 * 6. Controller.login.POST method에는 HttpSession 클래스를 매개변수로 설정한다
	 * 7. 정상 사용자 정보이면(userVO가 null이 아니면)
	 * 		setAttribute() method를 사용하여 사용자 정보를 변수에 setting한다
	 * 8. 정상 사용자가 아니면 removeAttribute() method를 사용하여 변수를 제거해버린다
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session, Model model) {
		log.debug(userVO.toString());

		String loginMessage = null;
		UserVO loginUserVO = userService.findById(userVO.getUsername());

		if (loginUserVO == null) { // 가입 된 적 없을 때
			loginMessage = "USERNAME FAIL";
		}

		// username은 있지만 password가 다른 경우
		else if (!loginUserVO.getPassword().equals(userVO.getPassword())) {
			loginMessage = "PASSWORD FAIL";
		}

		if (loginMessage == null) {
			session.setAttribute("USER", loginUserVO);
		} else {
			session.removeAttribute("USER");
		}

		model.addAttribute("Login_message", loginMessage);

		return "user/login_ok";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");

		/*
		 * 로그아웃이 끝나면 web browser의 주소창에 /user/login을 입력하고
		 * Enter 누르기
		 */

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		/* 
		 * 이 method를 요청하는 url은 /user/join이다
		 * 
		 * return null을 실행하면
		 * return user/join을 실행한 것과 같다
		 * views/user/join.jsp를 rendering 하라는 의미
		 */

		return null;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("JOIN");
		log.debug(userVO.toString());
		userService.join(userVO);

		/*
		 * return "문자열" : Forwarding
		 * => views/문자열.jsp rendering
		 * 
		 * return "redirect:/url" : pass, toss, redirect
		 * => 서버의 localhost:8080/url을 다시 request
		 * => web browse 주소창에 localhost:8080/url을 입력하고 Enter를 누르는 것과 같은 효과
		 */

		return "redirect:/user/login";
	}

	/*
	 * fetch(`${rootPath}/user/idcheck/${username.value}`)
	 * 
	 * 만약 username을 입력했으면
	 * /user/idcheck/입력값 처럼 요청 url을 만들어서 요청 수행
	 */

	/*
	 * id를 email 주소로 사용 할 때 PathVarriable로 받을 경우
	 * dot(.) 이후의 문자열을 잘라버리는 현상이 있다
	 * 이때는 정규식(Rexp)를 사용하여 dot(.) 이후 문자열을 포함하여
	 * 변수에 저장하도록 변수를 수정
	 * 		{username:.+} 형식으로 지정 
	 */

	@ResponseBody
	@RequestMapping(value = "/idcheck/{username:.+}", method = RequestMethod.GET)
	public String idcheck(@PathVariable String username) {
		UserVO userVO = userService.findById(username);

//		if (userVO.getUsername().equalsIgnoreCase(username)) {
//			return "FAIL";
//		} else {
//			return "OK";
//		}

		if (userVO == null) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

}
