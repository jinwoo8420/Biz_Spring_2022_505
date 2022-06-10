package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.BookService;
import com.callor.naver.service.BuyBookService;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController {

	// UserService interface를 상속받은 어떤 클래스를 주입받겠다는 선언
	@Autowired
	@Qualifier(QualifierConfig.SERVICE.USER_V2)
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private BuyBookService buyService;

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

	/*
	 * 매개변수로 설정한 HttpSession
	 * Controller의 각 method는 Spring으로부터 HttpSession 객체를 주입 받을 수 있다
	 * 
	 *  HttpSession 객체에는 client와 server간에 상태(status)를 유지하는 정보를 담을 수 있다
	 *  
	 *  여기에 담긴 데이터는 서버가 Run하는 동안 일정 조건을 만족하는 동안 Session을 제거하지 않는 한
	 *  계속 메모리에 값이 남아 있다
	 *  
	 *  큰 데이터를 HttpSession에 담는 것은 좋지 않다
	 *  최소한으로 status를 유지 할 수 있는 데이터만 담는 것이 좋다
	 *  필요가 없어지면 반드시 remove 해주는 것이 좋다
	 *  
	 *  프로젝트의 어떤 method에서든지 한번 담은 session 정보는 전체 프로젝트의 Controller method에서
	 *  값을 참조 할 수 있다
	 */

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("USER");

		if (loginUser == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		// 로그인 한 사용자의 도서 구입 리스트 가져오기

		/*
		 * buyBook 리스트에는 b_isbn, b_username, b_date 값만 담긴 상태
		 * tbl_buybooks에는 3개의 칼럼만 존재하기 때문
		 * 이 데이터만 가지고는 구체적인 도서 정보를 알 수 없음
		 */

		List<BuyBookVO> buyBook = buyService.findByUserName(loginUser.getUsername());

		// 도서 구입 리스트의 ISBN을 도서 리스트에서 조회하여 가져오기

		/*
		 * 도서 구입 리스트를 for()문으로 반복하면서
		 * b_isbn 값으로 다시 도서 정보를 조회한다
		 * 조회된 도서 정보는 book 변수에 담는다
		 * book 변수는 type BookVO 이므로 도서의 구체적인 정보가 담기게 된다
		 */

		for (BuyBookVO buyVO : buyBook) {
			String isbn = buyVO.getB_isbn();
			BookVO book = bookService.findById(isbn);

			buyVO.setBook(book);
		}

		model.addAttribute("BUY_BOOK", buyBook);
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
