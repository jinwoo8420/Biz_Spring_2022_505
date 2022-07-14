package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * 프로젝트의 요청에 대하여 소수의 Controller를 만들고 처리 가능
 * 하지만 프로젝트 규모가 커지면 코드 관리가 어려워지고
 * 결국에는 프로젝트를 Refactoring 해야 됨
 */

@Slf4j
@RequestMapping(value = "/books")
public class BooksController {
	@Qualifier(QualifierConfig.SERVICE.BOOKS_V1)
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;

	}

	/*
	 * return 문자열 형식은
	 * 명시적으로 어떤 jsp 파일을 rendering 할 것인지 알려주는것
	 * 현재 method를 요청한 URL에 대하여  jsp를 명시적 전달
	 */

	@RequestMapping(value = { "/", "" })
	public String home() {

		return "redirect:/books/list";
	}

	@RequestMapping(value = "/list")
	public String list(Model model) {
		/*
		 * return null 형식은
		 * 암시적으로 어떤 jsp 파일을 rendering 할 것인지 알려주는 것
		 * 현재 method를 요청한 URL이 명시적으로 명확 할 경우
		 * null을 return 하면 Spring에서 자체적으로 폴더 / 파일 형식으로 구성
		 */

		List<BookVO> bookList = bookService.selectAll();

		// bookList에 담긴 데이터를 BOOKS 이름으로 변수에 담아 jsp 파일로 보내기
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("LAYOUT", "BOOK-LIST");

		return "home";
	}

	/*
	 * RequestMethod가 없는 Mapping은
	 * get 요청이나 POST 요청을 모두 처리하는 method가 되버린다
	 * 
	 * method = RequestMethod.GET로 지정하면 a tag link를 눌렀을 때의 요청만 처리하도록 역할 제한
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session) {

		model.addAttribute("LAYOUT", "BOOK-INPUT");

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		return "home";
	}

	/*
	 * method = POST가 부착된 form으로 감싼 데이터들이 전송되었을때
	 * 요청을 받아 처리 할 method 
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BookVO bookVO) {
		log.debug("도서정보 : " + bookVO.toString());

		int ret = bookService.insert(bookVO);

		/* 
		 * insert method를 호출하여 데이터를 저장 한 후
		 * return 된 결과에 따라 USER에게 메시지를 보여주고자 할 때
		 * 다음과 같은 코드를 사용한다
		 * 
		 * if (ret > 0) {
				return "OK";
			} else {
				return "FAIL";
			}		
		 */

		// insert 처리를 수행한 후 list 화면으로 전환
		return "redirect:/books/list";

		/*
		 * Forwarding
		 * Controller method의 return type이 String일 때
		 * views/*.jsp 파일을 열어 rendering을 수행한 후 USER에게 보여주기
		 * 
		 * redirect로 시작되는 문자열을 만나면 서버의 다른 URL로 요청을 전달
		 */
	}

	@RequestMapping(value = "/{isbn}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("isbn") String isbn, Model model) {
		BookVO bookVO = bookService.findById(isbn);

		model.addAttribute("BOOK", bookVO);
		model.addAttribute("LAYOUT", "BOOK-DETAIL");

		return "home";
	}

	/*
	 * 전달받은 id 값으로 데이터를 select하고 model에 담아서 입력 form으로 전달
	 */

	@RequestMapping(value = "/{isbn}/update", method = RequestMethod.GET)
	public String update(@PathVariable("isbn") String isbn, Model model) {
		BookVO bookVO = bookService.findById(isbn);

		model.addAttribute("BOOK", bookVO);
		model.addAttribute("LAYOUT", "BOOK-INPUT");

		return "home";
	}

	@RequestMapping(value = "/{isbn}/update", method = RequestMethod.POST)
	public String update(BookVO bookVO) {
		int ret = bookService.update(bookVO);
		String retStr = String.format("redirect:/books/%s/detail", bookVO.getIsbn());

		return retStr;
	}

	@RequestMapping(value = "/{isbn}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("isbn") String isbn) {
		int ret = bookService.delete(isbn); // 삭제한 데이터 개수를 return

		return "redirect:/books/list";
	}
}
