package com.callor.address.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.address.model.AddressVO;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final AddressService adrService;

	public HomeController(AddressService adrService) {
		this.adrService = adrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO adrVO) {

		log.debug(adrVO.toString());
		
//		int ret = adrService.insert(adrVO);

		return "home";
	}

}
