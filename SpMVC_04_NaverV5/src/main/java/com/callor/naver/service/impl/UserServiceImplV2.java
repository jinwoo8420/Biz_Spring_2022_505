package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * No qualifying bean of type 오류가 발생하는 경우
 * 1. 생성자를 통해서 주입받기
 * 2. Autowired를 사용하여 setter를 통해서 주입받기
 * 
 * 어디에도 해당하는 bean을 생성, 선언한 곳이 없을 때 발생하는 오류
 */

@Slf4j
@Service(QualifierConfig.SERVICE.USER_V2)
public class UserServiceImplV2 extends UserServiceImplV1 {

	@Autowired
	protected PasswordEncoder passwordEncoder;

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

}
