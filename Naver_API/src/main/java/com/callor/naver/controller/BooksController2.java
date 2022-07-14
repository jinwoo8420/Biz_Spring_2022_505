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
import com.callor.naver.service.BuyBookService;

import lombok.extern.slf4j.Slf4j;

/*
 * 프로젝트의 요청에 대하여 소수의 Controller를 만들고 처리 가능
 * 하지만 프로젝트 규모가 커지면 코드 관리가 어려워지고
 * 결국에는 프로젝트를 Refactoring 해야 됨
 */

@Slf4j
@RequestMapping(value = "/books")
@Controller
public class BooksController2 {
	@Qualifier(QualifierConfig.SERVICE.BOOKS_V1)
	private final BookService bookService;
	private final BuyBookService buyService;

	public BooksController2(BookService bookService, BuyBookService buyService) {
		this.bookService = bookService;
		this.buyService = buyService;
	}

	@RequestMapping(value = { "/", "" })
	public String home() {

		return "redirect:/books/list";
	}

	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<BookVO> bookList = bookService.selectAll();

		model.addAttribute("BOOKS", bookList);
		model.addAttribute("LAYOUT", "BOOK-LIST");

		return "home";
	}

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

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BookVO bookVO, HttpSession session, Model model) {
		log.debug("도서정보 : " + bookVO.toString());

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");
			return "redirect:/user/login";
		}

		int ret = buyService.insert(userVO, bookVO);

		return "redirect:/books/list";
	}

	@RequestMapping(value = "/{isbn}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("isbn") String isbn, Model model) {
		BookVO bookVO = bookService.findById(isbn);

		model.addAttribute("BOOK", bookVO);
		model.addAttribute("LAYOUT", "BOOK-DETAIL");

		return "home";
	}

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
		int ret = buyService.delete(isbn);
		int ret2 = bookService.delete(isbn);

		return "redirect:/books/list";
	}
}
