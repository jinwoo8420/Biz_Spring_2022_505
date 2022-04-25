package com.callor.app.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.service1.StudentService;

/*
 * Controller level에 @RequestMapping을 설정하면
 * Controller의 mapping과 method의 mapping이 서로 연결되어
 * RequestMapping을 구성한다
 * 
 * localhost:8080/school/student : StudentController의 mapping 연결
 * localhost:8080/school/student/list : StudentController#list()의 mapping 연결
 */

@RequestMapping(value = "/student")
@Controller
public class StudentController {
	/*
	 * Dependency inject 중 생성자 injection
	 */
	
	private final StudentService stService;
	
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
	
	/*
	 * return type이 String type인 method의 경우 null 값을 return하면 requsest Path 와 같은
	 * jsp파일을 찾아서 rendering을 수행한다
	 * 
	 * @RequestBosy 설정이 없어야 한다
	 */

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return null;
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return "student/input";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail() {
		return "student/detail_view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return "student/update";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "student/delete";
	}

}
