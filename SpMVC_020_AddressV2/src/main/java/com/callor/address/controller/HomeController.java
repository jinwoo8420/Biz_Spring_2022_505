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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final AddressService adrService;

	public HomeController(AddressService adrService) {
		this.adrService = adrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name = "pageno", required = false, defaultValue = "0") int pageno,
			SearchPage searchPage) {

		searchPage.setCurrentPageNo(pageno);

		adrService.searchAndPage(model, searchPage); // 페이지 계산

		List<AddressVO> adrVO = adrService.searchAndPage(searchPage); // 데이터 가져오기
		model.addAttribute("HOME", adrVO);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO adrVO) {
		int ret = adrService.insert(adrVO);

		return "redirect:/";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "write";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(AddressVO addr) {
		adrService.insert(addr);

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

		return "write";
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

	/*
	 * Controller의 method에서 문자열을 return하면
	 * tiles/layout.xml 파일에서 해당하는 문자열로 선언된 definition을 찾는다
	 * 해당하는 문자열로 선언된 definition이 있으면 layout.xml에 설정된 대로
	 * tiles가 작동되어 layout을 만들고 rendering하여 응답을 한다
	 * 
	 * 만약 layout.xml에 해당하는 definition이 없으면
	 * InternalResourceViewResolver가 작동되어 /views/문자열.jsp 파일을 찾아서 rendering하여 응답한다
	 */

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}

}
