package com.callor.sec.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.sec.model.UserVO;
import com.callor.sec.service.AdminService;
import com.callor.sec.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String adminPage(String username, Model model) {
		List<UserVO> userList = userService.selectAll();

		model.addAttribute("USERS", userList);
		model.addAttribute("LAYOUT", "ADMIN_PAGE");

		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String adminPage_update(String username, Model model, String error) {
		UserVO userVO = userService.findById(username);

		model.addAttribute("UPDATE", userVO);
		model.addAttribute("error", error);
		model.addAttribute("LAYOUT", "ADMIN_PAGE_UPDATE");

		return "home";
	}

	/*
	 * Spring Security에서 로그인이 성공하면 Principal이라는 클래스를 사용 가능
	 * principal.getName()을 실행하면 로그인한 사용자의 username을 추출
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String adminPage_update(UserVO userVO, Model model, Principal principal) {
		String admin = principal.getName();

		int ret = adminService.update(userVO, admin);

		if (ret < 0) {
			return String.format("redirect:/admin/update?" + "username=%s&error=ADMIN_PASS", userVO.getUsername());
		}

		return "redirect:/admin";

	}

}
