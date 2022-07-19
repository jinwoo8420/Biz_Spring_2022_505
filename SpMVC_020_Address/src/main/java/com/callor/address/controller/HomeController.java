package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<AddressVO> adrVO = adrService.selectAll();
		model.addAttribute("HOME", adrVO);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO adrVO) {
		int ret = adrService.insert(adrVO);

		return "redirect:/";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("seq") String strSeq, Model model) {
		long seq = Long.valueOf(strSeq);

		AddressVO adr = adrService.findById(seq);

		model.addAttribute("DETAIL", adr);

		return "detail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("seq") String strSeq, Model model) {
		long seq = Long.valueOf(strSeq);

		AddressVO adr = adrService.findById(seq);

		model.addAttribute("UPDATE", adr);

		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(AddressVO adrVO) {
		int ret = adrService.update(adrVO);

		String str = String.format("redirect:/detail?seq=%s", adrVO.getA_seq());

		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("seq") String strSeq) {
		long seq = Long.valueOf(strSeq);

		int ret = adrService.delete(seq);

		return "redirect:/";
	}

}
