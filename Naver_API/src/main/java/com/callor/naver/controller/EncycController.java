package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.EncycVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.EncycService;

@RequestMapping(value = "/encyc")
@Controller
public class EncycController {
	private final EncycService encycService;

	public EncycController(EncycService encycService) {
		this.encycService = encycService;
	}

	@RequestMapping(value = { "/", "" })
	public String encyc_list() {
		return "encyc/encyc_list";
	}

	@RequestMapping(value = "/encyc_list")
	public String list(Model model, HttpSession session, EncycVO encycVO) {
		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			List<EncycVO> encycList = encycService.selectAll();
			model.addAttribute("ENCYCS", encycList);
		}

		else if (userVO != null) {
			List<EncycVO> encycList = encycService.findByUser(userVO.getUsername());
			encycVO.setE_username(userVO.getUsername());

			model.addAttribute("ENCYCS", encycList);
		}

		model.addAttribute("LAYOUT", "ENCYC-LIST");

		return "home";
	}

	@RequestMapping(value = "/encyc_insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session, EncycVO encycVO) {

		model.addAttribute("LAYOUT", "ENCYC-INPUT");

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		encycVO.setE_username(userVO.getUsername());
		model.addAttribute("E_USER", encycVO.getE_username());

		return "home";
	}

	@RequestMapping(value = "/encyc_insert", method = RequestMethod.POST)
	public String insert(EncycVO encycVO, HttpSession session, Model model) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		encycVO.setE_username(userVO.getUsername());
		model.addAttribute("E_USER", encycVO.getE_username());

		int ret = encycService.insert(encycVO);

		return "redirect:/encyc/encyc_list";
	}

	@RequestMapping(value = "/{e_seq}/encyc_detail", method = RequestMethod.GET)
	public String detail(@PathVariable("e_seq") String seq, Model model) {
		EncycVO encycVO = encycService.findById(seq);

		model.addAttribute("ENCYC", encycVO);
		model.addAttribute("LAYOUT", "ENCYC-DETAIL");

		return "home";
	}

	@RequestMapping(value = "/{e_seq}/encyc_update", method = RequestMethod.GET)
	public String update(@PathVariable("e_seq") String seq, Model model, HttpSession session) {
		EncycVO encycVO = encycService.findById(seq);

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		encycVO.setE_username(userVO.getUsername());
		model.addAttribute("E_USER", encycVO.getE_username());

		model.addAttribute("MOVIE", encycVO);
		model.addAttribute("LAYOUT", "ENCYC-INPUT");

		return "home";
	}

	@RequestMapping(value = "/{e_seq}/encyc_update", method = RequestMethod.POST)
	public String update(EncycVO encycVO, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		encycVO.setE_username(userVO.getUsername());

		int ret = encycService.update(encycVO);

		String retStr = String.format("redirect:/encyc/%s/encyc_detail", encycVO.getE_seq());

		return retStr;
	}

	@RequestMapping(value = "/{e_seq}/encyc_delete", method = RequestMethod.GET)
	public String delete(@PathVariable("e_seq") String seq, Model model, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}

		int ret = encycService.delete(seq);

		return "redirect:/encyc/encyc_list";
	}
}
