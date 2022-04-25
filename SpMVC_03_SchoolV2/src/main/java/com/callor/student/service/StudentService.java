package com.callor.student.service;

import java.util.List;

import com.callor.student.domain.StudentVO;

public interface StudentService {
	public int insert(StudentVO studentVO);
	public List<StudentVO> selectAll();
	public StudentVO findbyId(String stNum);
}
