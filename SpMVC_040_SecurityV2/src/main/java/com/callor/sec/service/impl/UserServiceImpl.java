package com.callor.sec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.sec.model.UserVO;
import com.callor.sec.persistance.UserDao;
import com.callor.sec.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// Bean을 생성하는 Annotation / method를 자동 실행하도록 하는 트릭
	@Bean
	public void create_table() {
		userDao.create_user_table();
		userDao.create_author_table();
	}

	@Override
	public void create_user_table() {
	}

	@Override
	public void create_author_table() {
	}

	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		return userDao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		return userDao.update(vo);
	}

	@Override
	public int delete(String id) {
		return userDao.delete(id);
	}

}
