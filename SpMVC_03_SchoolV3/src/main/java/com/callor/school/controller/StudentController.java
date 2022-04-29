package com.callor.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.domain.StudentVO;
import com.callor.school.service.StudentService;

@Controller
public class StudentController {
	/*
	 * Controller에서 Service interface를 상속받은 클래스 중에 한가지를 사용하고자 한다
	 * 
	 * Java : 인터페이스 객체 = new 클래스생성자()
	 * 
	 * spring framework project : private final 인터페이스 객체 선언 임의 생성자 만든 후 argument로 전달
	 * 받고 객체에 대입하는 코드 만들기 이후 미리 bean으로 생성되어 있는 개체들 중에 자동으로 주입
	 */

	private final StudentService stService;

	public StudentController(StudentService stService) {
		this.stService = stService;
	}

	@RequestMapping(value = "/student/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("ST_LIST", stService.selectAll());

		return "student/list";
	}

	@RequestMapping(value = "/student/detail", method = RequestMethod.GET)
	public String detail(String stNum, Model model) {
		StudentVO stVO = stService.findByStNum(stNum);
		model.addAttribute("ST", stVO);

		return null;
	}

	@RequestMapping(value = "/student/input", method = RequestMethod.GET)
	public String insert() {
		return "student/input";
	}

}
