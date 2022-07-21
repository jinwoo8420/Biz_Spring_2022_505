package com.callor.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao stDao;

	@Override
	public List<StudentVO> selectAll() {
		return stDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		return stDao.findById(id);
	}

	@Override
	public int insert(StudentVO vo) {
		stDao.insert(vo);
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		stDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		stDao.delete(id);
		return 0;
	}

}
