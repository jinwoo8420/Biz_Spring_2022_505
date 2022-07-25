package com.callor.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService stService;

	@Autowired
	private ScoreService scService;

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	@ResponseBody // JSON type으로 return
	public List<StudentVO> home() {
		List<StudentVO> stList = stService.selectAll();

		return stList;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stList = stService.selectAll();

		model.addAttribute("STUDENTS", stList);

		return "student/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("st_num") String st_num, Model model) {
		StudentVO stVO = stService.findById(st_num);
		List<ScoreVO> scVO = scService.findByStNum(st_num);

		model.addAttribute("DETAIL", stVO);
		model.addAttribute("SCORE", scVO);

		return "student/detail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("st_num") String st_num, Model model) {
		StudentVO stVO = stService.findById(st_num);

		model.addAttribute("UPDATE", stVO);

		return "student/insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(StudentVO stVO) {
		int ret = stService.update(stVO);

		String str = String.format("redirect:/student/detail?st_num=%s", stVO.getSt_num());

		return str;
	}
}
