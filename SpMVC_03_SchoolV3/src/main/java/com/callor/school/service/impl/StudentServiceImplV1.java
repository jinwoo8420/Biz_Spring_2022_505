package com.callor.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.school.dao.StudentDao;
import com.callor.school.domain.StudentVO;
import com.callor.school.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {
	// web application에서는 Service 클래스의 클래스 영역에 변수를 선언하지 않는다

	private final StudentDao stDao;

	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}

	@Override
	public List<StudentVO> selectAll() {
		return stDao.selectAll();
	}

	// TODO 학생 데이터 추가
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	// TODO 학생 데이터 ID로 조회
	@Override
	public StudentVO findbyId(String stNum) {
		return null;
	}

	@Override
	public StudentVO findByStNum(String stNum) {
		return stDao.findByNum(stNum);
	}

}
