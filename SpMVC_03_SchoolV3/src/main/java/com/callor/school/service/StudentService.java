package com.callor.school.service;

import java.util.List;

import com.callor.school.domain.StudentVO;

public interface StudentService {
	public int insert(StudentVO studentVO);
	public List<StudentVO> selectAll();
	public StudentVO findbyId(String stNum);
	public StudentVO findByStNum(String stNum);
}
