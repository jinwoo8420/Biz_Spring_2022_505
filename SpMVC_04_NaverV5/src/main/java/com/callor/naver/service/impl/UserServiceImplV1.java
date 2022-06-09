package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.UserDao;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * No qualifying bean of type 오류가 발생하는 경우
 * 1. 생성자를 통해서 주입받기
 * 2. Autowired를 사용하여 setter를 통해서 주입받기
 * 
 * 어디에도 해당하는 bean을 생성, 선언한 곳이 없을 때 발생하는 오류
 */

@Slf4j
@Service(QualifierConfig.SERVICE.USER_V1)
public class UserServiceImplV1 implements UserService {

	@Autowired
	protected UserDao userDao;

	@Autowired
	@Override
	public void create_user_table() {

		try {
			log.debug("TABLE 생성");
			userDao.create_user_table();
		} catch (Exception e) {
			log.debug("TABLE 생성 X");
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
		return null;
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

		if (loginUser != null && loginUser.getPassword().equals(userVO.getPassword())) {
			return loginUser;
		}

		return null;
	}

	/*
	 * 최초 가입자는 ADMIN 권한 부여
	 * 그외는 GUEST 권한 부여
	 */

	@Override
	public int join(UserVO userVO) {
		/*
		 * 가입 요청한 정보가 최초인지 검사하여 최초 가입 요청일 경우
		 * 현재 사용자의 role 정보를 ADMIN으로 설정
		 */
		List<UserVO> users = userDao.selectAll();

		if (users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("GUEST");
		}

		int ret = userDao.insert(userVO);

		return ret;
	}

}
