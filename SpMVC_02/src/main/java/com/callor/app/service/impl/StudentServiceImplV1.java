package com.callor.app.service.impl;

import org.springframework.stereotype.Service;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {

	// TODO 학생 데이터 추가
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	// TODO 전체 데이터 가져오기
	@Override
	public StudentVO[] selectAll() {
		return null;
	}

	// TODO 학생 데이터 ID로 조회
	@Override
	public StudentVO findbyId(String stNum) {
		return null;
	}

}
