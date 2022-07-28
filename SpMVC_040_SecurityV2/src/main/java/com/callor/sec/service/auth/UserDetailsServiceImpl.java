package com.callor.sec.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.sec.model.UserVO;
import com.callor.sec.persistance.UserDao;

/*
 * Spring Security에서 로그인 사용자 정보를 DB로부터 가져와서 핸들링하는 클래스
 * 
 * Security UserDeatilsService 인터페이스를 상속받고
 * loadUserByUsername() method를 정의한다
 */

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserDao userDao;

	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * 로그인 한 사용자의 username을 매개변수로 전달받아
	 * UserDao를 통해 로그인 한 사용자 정보를 DB로부터 가져온다
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDao.findById(username);

		if (userVO == null) {
			// Spring Security에게 exception을 강제로 발생시켜 메시지 전달
			throw new UsernameNotFoundException(username + " : 가입 필요");
		}

		return userVO;
	}

}
