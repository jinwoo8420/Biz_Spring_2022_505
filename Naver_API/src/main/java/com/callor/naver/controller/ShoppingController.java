package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.ShoppingVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.ShoppingService;

@RequestMapping(value = "/shopping")
@Controller
public class ShoppingController {
	private final ShoppingService shoppingService;

	public ShoppingController(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@RequestMapping(value = { "/", "" })
	public String home() {

		return "redirect:/shopping/shopping_list";
	}
	
	@RequestMapping(value = "/shopping_list")
	public String list(Model model, HttpSession session, ShoppingVO shoppingVO) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		
		if(userVO == null) {
			List<ShoppingVO> shoppingList = shoppingService.selectAll();
			model.addAttribute("SHOPPINGS", shoppingList);
		}

		else if (userVO != null) {
			List<ShoppingVO> shoppingList = shoppingService.findByUser(userVO.getUsername());
			shoppingVO.setS_username(userVO.getUsername());

			model.addAttribute("SHOPPINGS", shoppingList);
		}

		model.addAttribute("LAYOUT", "SHOPPING-LIST");

		return "home";
	}

	@RequestMapping(value = "/shopping_insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session, ShoppingVO shoppingVO) {

		model.addAttribute("LAYOUT", "SHOPPING-INPUT");

		UserVO userVO = (UserVO) session.getAttribute("USER");

		if (userVO == null) {
			model.addAttribute("error", "LOGIN_NEED");

			return "redirect:/user/login";
		}
		
		shoppingVO.setS_username(userVO.getUsername());
		model.addAttribute("S_USER", shoppingVO.getS_username());

		return "home";
	}

	@RequestMapping(value = "/shopping_insert", method = RequestMethod.POST)
	public String insert(ShoppingVO shoppingVO, HttpSession session,Model model) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		shoppingVO.setS_username(userVO.getUsername());
		model.addAttribute("S_USER", shoppingVO.getS_username());

		int ret = shoppingService.insert(shoppingVO);

		return "redirect:/shopping/shopping_list";
	}

	@RequestMapping(value = "/{s_seq}/shopping_detail", method = RequestMethod.GET)
	public String detail(@PathVariable("s_seq") String s_seq, Model model) {
		ShoppingVO shoppingVO = shoppingService.findById(s_seq);

		model.addAttribute("SHOPPING", shoppingVO);
		model.addAttribute("LAYOUT", "SHOPPING-DETAIL");

		return "home";
	}

	@RequestMapping(value = "/{s_seq}/shopping_update", method = RequestMethod.GET)
	public String update(@PathVariable("s_seq") String s_seq, Model model) {
		ShoppingVO shoppingVO = shoppingService.findById(s_seq);

		model.addAttribute("SHOPPING", shoppingVO);
		model.addAttribute("LAYOUT", "SHOPPING-INPUT");

		return "home";
	}

	@RequestMapping(value = "/{s_seq}/shopping_update", method = RequestMethod.POST)
	public String update(ShoppingVO shoppingVO, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		shoppingVO.setS_username(userVO.getUsername());

		int ret = shoppingService.update(shoppingVO);
		String retStr = String.format("redirect:/shopping/%s/shopping_detail", shoppingVO.getS_seq());

		return retStr;
	}

	@RequestMapping(value = "/{s_seq}/shopping_delete", method = RequestMethod.GET)
	public String delete(@PathVariable("s_seq") String s_seq) {
		int ret = shoppingService.delete(s_seq);

		return "redirect:/shopping/shopping_list";
	}
}
