package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.service.AddressService;

@Controller
public class HomeController {

	private final AddressService adrService;

	public HomeController(AddressService adrService) {
		this.adrService = adrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name = "pageno", required = false, defaultValue = "0") int pageno) {
//		List<AddressVO> adrVO = adrService.selectAll();

		SearchPage searchpage = SearchPage.builder().a_name("").limit(10).offset(pageno * 10).build();

		searchpage.setCurrentPageNo(pageno);

		adrService.searchAndPage(model, searchpage); // 페이지 계산

		List<AddressVO> adrVO = adrService.searchAndPage(searchpage); // 데이터 가져오기
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
