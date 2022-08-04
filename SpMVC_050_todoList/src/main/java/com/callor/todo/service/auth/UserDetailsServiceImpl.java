package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

/*
 * Spring Security에서 지원하는 UserDetailsService를 상속받아 Class 작성
 */

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserDao userDao;

	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * DB로부터 사용자 정보를 select하여 사용자 정보 있는지 검사
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDao.findById(username);

		/*
		 * 사용자 정보가 DB에 없으면 exception 발생시켜서 Security에게 알리기
		 */

		if (userVO == null) {
			throw new UsernameNotFoundException(username + " : 회원가입 필요");
		}

		List<AuthorVO> authos = userDao.select_auths(username);

		if (authos.size() < 1) {
			throw new UsernameNotFoundException(String.format("[ %s ] 권한 X", username));
		}

		List<GrantedAuthority> grantList = new ArrayList<>();

		/*
		 * 사용자의 권한 정보를 문자열에서 GrantedAuthority 객체로 변환하기
		 */
		for (AuthorVO auth : authos) {
			grantList.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}

		/*
		 * GrantedAuthority 객체로 변환된 ROLE 정보를
		 * 사용자 정보에 setting
		 */
		userVO.setAuthorities(grantList);

		return userVO;
	}

}
