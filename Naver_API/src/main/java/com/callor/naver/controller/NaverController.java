package com.callor.naver.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.service.NaverService;

@RequestMapping(value = "/naver")
@Controller
public class NaverController {
	private final NaverService naverService;

	public NaverController(NaverService naverService) {
		this.naverService = naverService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {
		return "naver/search";
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String home(String cat, String search, Model model) {
		String queryString = naverService.queryString("BOOK", search);

		if (cat.equals("SHOPPING")) {
			queryString = naverService.queryString("SHOPPING", search);
			List<Object> shoppingList = naverService.getNaver(queryString);
			model.addAttribute("SHOPPINGS", shoppingList);

			return "naver/shopping_search";
		} else if (cat.equals("MOVIE")) {
			queryString = naverService.queryString("MOVIE", search);
			List<Object> movieList = naverService.getNaver(queryString);
			model.addAttribute("MOVIES", movieList);

			return "naver/movie_search";
		}

		List<Object> bookList = naverService.getNaver(queryString);

		model.addAttribute("BOOKS", bookList);

		return "naver/book_search";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String book_search(String title, Model model) {
		String queryString = naverService.queryString("BOOK", title);

		List<Object> bookList = naverService.getNaver(queryString);

		model.addAttribute("BOOKS", bookList);

		return "naver/book_search";
	}

	@ResponseBody
	@RequestMapping(value = "/{isbn}/book", method = RequestMethod.GET, produces = NaverConfig.APP_JSON)
	public Object book(@PathVariable("isbn") String isbn) {
		String queryString = naverService.queryString("BOOK", isbn);

		List<Object> bookList = naverService.getNaver(queryString);

		return bookList.get(0);
	}

	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String shopping_search(String title, Model model) {
		String queryString = naverService.queryString("SHOPPING", title);

		List<Object> shoppingList = naverService.getNaver(queryString);

		model.addAttribute("SHOPPINGS", shoppingList);

		return "naver/shopping_search";
	}

	@ResponseBody
	@RequestMapping(value = "/{title}/shopping", method = RequestMethod.GET, produces = NaverConfig.APP_JSON)
	public Object shopping(@PathVariable("title") String title) {
		String queryString = naverService.queryString("SHOPPING", title);

		List<Object> shoppingList = naverService.getNaver(queryString);

		return shoppingList.get(0);
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String movie_search(String title, Model model) {
		String queryString = naverService.queryString("MOVIE", title);

		List<Object> movieList = naverService.getNaver(queryString);

		model.addAttribute("MOVIES", movieList);

		return "naver/movie_search";
	}

	@ResponseBody
	@RequestMapping(value = "/{title}/movies", method = RequestMethod.GET, produces = NaverConfig.APP_JSON)
	public Object movie(@PathVariable("title") String title) {
		String queryString = naverService.queryString("MOVIE", title);

		List<Object> movieList = naverService.getNaver(queryString);

		return movieList.get(0);
	}

}
