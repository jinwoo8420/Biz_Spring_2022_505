package com.callor.school.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.pesistance.UserDao;

@Service("userServiceV2")
public class UserServiceImplV2 extends UserServiceImplV1 {

	// V1 생성자 호출
	public UserServiceImplV2(UserDao userDao, PasswordEncoder pass) {
		super(userDao, pass);
	}

	@Override
	public UserVO login(UserVO userVO) {
		// Controller에서 전달받은 로그인 정보에서 username과 password 추출
		String username = userVO.getUsername();
		String password = userVO.getPassword();

		// username으로 회원 DB에서 데이터 select
		UserVO joinUserVO = userDao.findById(username);

		/* 
		 * select한 데이터가 null이면 username이 없다
		 * 잘못 입력했거나 아직 회원가입하지 않은 상태
		 * select한 데이터가 null이 아니면 username이 있다
		 */
		if (joinUserVO != null) {
//			log.debug("JOIN : " + joinUserVO.toString());

			/*
			 * username으로 조회한 데이터가 있으면
			 * DB에 저장된 password와 입력한 password 비교
			 */
			boolean bYes = pass.matches(password, joinUserVO.getPassword());

			// 비밀번호가 일치하지 않으면 null을 return하고 종료하기
			if (bYes == false) {
				return null;
			}
		}

		// 정상 로그인되면 joinUserVO에는 사용자 정보 데이터가 담기고 그렇지 않으면 null이 담겨있다
		return joinUserVO;
	}
}
