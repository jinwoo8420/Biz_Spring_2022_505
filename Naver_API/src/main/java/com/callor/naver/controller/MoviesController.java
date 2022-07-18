package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.MovieVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.MovieService;

@RequestMapping(value = "/movies")
@Controller
public class MoviesController {
	private final MovieService movieService;

	public MoviesController(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping(value = { "/", "" })
	public String movies_list() {
		return "movies/movies_list";
	}
	
	@RequestMapping(value = "/movies_list")
	public String list(Model model, HttpSession session, MovieVO movieVO) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		
		if(userVO == null) {
			List<MovieVO> movieList = movieService.selectAll();
			model.addAttribute("MOVIES", movieList);
		}

		else if (userVO != null) {
			List<MovieVO> movieList = movieService.findByUser(userVO.getUsername());
			movieVO.setM_username(userVO.getUsername());

			model.addAttribute("MOVIES", movieList);
		}

		model.addAttribute("LAYOUT", "MOVIE-LIST");

		return "home";
	}

	@RequestMapping(value = "/movies_insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session, MovieVO movieVO) {

		model.addAttribute("LAYOUT", "MOVIE-INPUT");

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}
		
		movieVO.setM_username(userVO.getUsername());
		model.addAttribute("M_USER", movieVO.getM_username());

		return "home";
	}

	@RequestMapping(value = "/movies_insert", method = RequestMethod.POST)
	public String insert(MovieVO movieVO, HttpSession session,Model model) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		movieVO.setM_username(userVO.getUsername());
		model.addAttribute("M_USER", movieVO.getM_username());

		int ret = movieService.insert(movieVO);

		return "redirect:/movies/movies_list";
	}

	@RequestMapping(value = "/{m_code}/movies_detail", method = RequestMethod.GET)
	public String detail(@PathVariable("m_code") String title, Model model) {
		MovieVO movieVO = movieService.findById(title);

		model.addAttribute("MOVIE", movieVO);
		model.addAttribute("LAYOUT", "MOVIE-DETAIL");

		return "home";
	}

	@RequestMapping(value = "/{m_code}/movie_update", method = RequestMethod.GET)
	public String update(@PathVariable("m_code") String title, Model model) {
		MovieVO movieVO = movieService.findById(title);

		model.addAttribute("MOVIE", movieVO);
		model.addAttribute("LAYOUT", "MOVIE-INPUT");

		return "home";
	}

	@RequestMapping(value = "/{m_code}/movie_update", method = RequestMethod.POST)
	public String update(MovieVO movieVO, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		movieVO.setM_username(userVO.getUsername());

		int ret = movieService.update(movieVO);
		String retStr = String.format("redirect:/movies/%s/movies_detail", movieVO.getM_code());

		return retStr;
	}

	@RequestMapping(value = "/{m_code}/movies_delete", method = RequestMethod.GET)
	public String delete(@PathVariable("m_code") String title) {
		int ret = movieService.delete(title);

		return "redirect:/movies/movies_list";
	}
}
