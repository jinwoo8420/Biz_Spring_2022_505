package com.callor.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value = "/score")
public class ScoreController {
	private final StudentService stService;
	private final ScoreService scService;

	public ScoreController(StudentService stService, ScoreService scService) {
		this.stService = stService;
		this.scService = scService;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String st_num, Model model) {
		StudentVO student = stService.findById(st_num);
		model.addAttribute("STUDENT", student);

		return "score/insert";
	}

	/*
	 * 한개의 form에 다수의 input이 같은 이름으로 존재할 경우
	 * Controller에서 데이터를 받을 때 문자열 배열로 데이터를 받는다
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(String st_num, String[] sb_code, String[] sc_score) {
		scService.updateScore(st_num, sb_code, sc_score);

		String str = String.format("redirect:/student/detail?st_num=%s", st_num);

		return str;
	}
}
