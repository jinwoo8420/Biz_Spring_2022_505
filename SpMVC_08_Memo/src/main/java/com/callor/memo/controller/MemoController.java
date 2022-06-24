package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

@Controller
@RequestMapping(value = "/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		MemoVO memoVO = MemoVO.builder().m_date(dayFormat.format(date)).m_time(timeFormat.format(date))
				.m_author("1223wlsdn@naver.com").build();

		model.addAttribute("memoVO", memoVO);

		return "/memo/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO, @RequestParam("img") MultipartFile file) {

		try {
			String filename = memoService.fileUp(file);
			memoVO.setM_image(filename);
			int ret = memoService.insert(memoVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/{m_seq}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("m_seq") String m_seq, Model model) {
		MemoVO memoVO = memoService.findById(m_seq);

		model.addAttribute("MEMO", memoVO);

		return "/memo/detail";

	}

	@RequestMapping(value = "/{m_seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("m_seq") String m_seq, Model model) {

		MemoVO memoVO = memoService.findById(m_seq);
		model.addAttribute("memoVO", memoVO);

		return "/memo/insert";

	}

	@RequestMapping(value = "/{m_seq}/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("memoVO") MemoVO memoVO, @RequestParam("img") MultipartFile file) {

		try {
			String filename = memoService.fileUp(file);
			memoVO.setM_image(filename);
			int ret = memoService.update(memoVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String retStr = String.format("redirect:/memo/%s/detail", memoVO.getM_seq());
		return retStr;

	}

	@RequestMapping(value = "/{m_seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("m_seq") String m_seq) {

		int ret = memoService.delete(m_seq);
		return "redirect:/";
	}
}
