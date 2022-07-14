package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.UserDao;
import com.callor.naver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	protected UserDao userDao;
	
	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Autowired
	@Override
	public void create_user_table() {

		try {
			userDao.create_user_table();
		} catch (Exception e) {
		}
	}

	@Override
	public List<UserVO> findByName(String name) {
		return null;
	}

	@Override
	public List<UserVO> findByNickName(String nickname) {
		return null;
	}

	@Override
	public UserVO findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<UserVO> selectAll() {
		return null;
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public UserVO login(UserVO userVO) {
		UserVO loginUser = userDao.findById(userVO.getUsername());

		String encPassword = loginUser.getPassword();
		String planPassword = userVO.getPassword();

		if (passwordEncoder.matches(planPassword, encPassword)) {
			return loginUser;
		}

		return null;
	}


	@Override
	public int join(UserVO userVO) {
		List<UserVO> users = userDao.selectAll();

		if (users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("GUEST");
		}

		String planPassward = userVO.getPassword();
		String encPassward = passwordEncoder.encode(planPassward);

		userVO.setPassword(encPassward);

		userDao.insert(userVO);

		return 0;
	}

}
