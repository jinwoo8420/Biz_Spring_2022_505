package com.callor.school.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.pesistance.UserDao;
import com.callor.school.service.UserService;

/*
 * UserServiceImplV1 클래스를 Component(bean)로 등록하기
 */

@Service("userServiceV1")
public class UserServiceImplV1 implements UserService {
	protected final UserDao userDao;
	protected final PasswordEncoder pass;

	public UserServiceImplV1(UserDao userDao, PasswordEncoder pass) {
		this.userDao = userDao;
		this.pass = pass;
	}

	@Override
	public UserVO login(UserVO userVO) {
		String username = userVO.getUsername();
		String password = userVO.getPassword();

		if (username.equalsIgnoreCase("jinwoo8420") && password.equals("1234")) {
			userVO.setName("김철수");
			userVO.setRole("ADMIN");
			userVO.setEmail("1223wlsdn@naver.com");
		} else {
			userVO = null;
		}

		return userVO;
	}

	/*
	 * 회원가입 처리
	 * 
	 * 1. 최초로 회원가입을 실행하는 가입자는 ADMIN role 부여
	 * 2. 두번째 이후 회원가입을 실행하는 가입자는 USER role 부여
	 */

	@Override
	public UserVO join(UserVO userVO) {
		// 1. user table에 데이터가 있는지 확인하기 위해 전체 데이터 select
		List<UserVO> userList = userDao.selectAll(); // 만약 데이터가 없으면 null return

		// 회원가입 한 user의 정보를 저장하기 전에 비밀번호 암호화하기
		String encPassword = pass.encode(userVO.getPassword());
		userVO.setPassword(encPassword);

		if (userList == null || userList.size() < 1) {
			userVO.setRole("ADMIN"); // 데이터가 없으면 최초 가입 이므로 ADMIN 부여
		} else {
			userVO.setRole("USER");
		}

		userDao.insert(userVO);

		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String io) {
		// TODO Auto-generated method stub
		return 0;
	}

}
