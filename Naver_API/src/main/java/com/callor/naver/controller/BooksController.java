package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.BookService;

@RequestMapping(value = "/books")
@Controller
public class BooksController {
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = { "/", "" })
	public String home() {

		return "redirect:/books/list";
	}

	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session, BookVO bookVO) {
		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			List<BookVO> bookList = bookService.selectAll();
			model.addAttribute("BOOKS", bookList);
		}

		else if (userVO != null) {
			List<BookVO> bookList = bookService.findByUser(userVO.getUsername());
			bookVO.setB_username(userVO.getUsername());

			model.addAttribute("BOOKS", bookList);
		}

		model.addAttribute("LAYOUT", "BOOK-LIST");

		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session, BookVO bookVO) {

		model.addAttribute("LAYOUT", "BOOK-INPUT");

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		bookVO.setB_username(userVO.getUsername());
		model.addAttribute("B_USER", bookVO.getB_username());

		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BookVO bookVO, HttpSession session, Model model) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		bookVO.setB_username(userVO.getUsername());
		model.addAttribute("B_USER", bookVO.getB_username());

		int ret = bookService.insert(bookVO);

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
	public String update(@PathVariable("isbn") String isbn, Model model, HttpSession session) {
		BookVO bookVO = bookService.findById(isbn);

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		bookVO.setB_username(userVO.getUsername());
		model.addAttribute("B_USER", bookVO.getB_username());

		model.addAttribute("BOOK", bookVO);
		model.addAttribute("LAYOUT", "BOOK-INPUT");

		return "home";
	}

	@RequestMapping(value = "/{isbn}/update", method = RequestMethod.POST)
	public String update(@PathVariable("isbn") String isbn, BookVO bookVO, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		bookVO.setB_username(userVO.getUsername());
		bookVO.setIsbn(isbn);

		int ret = bookService.update(bookVO);

		String retStr = String.format("redirect:/books/%s/detail", bookVO.getIsbn());

		return retStr;
	}

	@RequestMapping(value = "/{isbn}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("isbn") String isbn, Model model, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		int ret = bookService.delete(isbn);

		return "redirect:/books/list";
	}
}
