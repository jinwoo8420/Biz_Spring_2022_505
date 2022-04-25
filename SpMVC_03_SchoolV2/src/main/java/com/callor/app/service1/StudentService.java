package com.callor.app.service1;

import java.util.List;

import com.callor.app.controller.domain1.StudentVO;

public interface StudentService {
	/*
	 * CRUD method의 prototype 선언
	 * C(Create, insert) : 새로운 데이터 추가
	 * R(Read, selectAll, findByStNum) : 데이터 읽기
	 * U(Update, update) : 기존 데이터 변경
	 * D(Delete, delete) : 기존 데이터 중 삭제
	 */
	
	public List<StudentVO> selectAll();
	public StudentVO findByStNum(String stNum);
	public Integer insert(StudentVO stVO);
	public Integer update(StudentVO stVO);
	public Integer delete(StudentVO stNum);
	
	public List<StudentVO> findByStTel(String stTel);
	public List<StudentVO> findByStName(String stName);
	public List<StudentVO> findByStAddr(String stAddr);
	
}
