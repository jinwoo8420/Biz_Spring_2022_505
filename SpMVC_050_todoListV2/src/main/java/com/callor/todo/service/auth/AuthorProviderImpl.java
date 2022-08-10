package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider {

	@Autowired
	private UserDao userDao;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/*
		 * getPrincipal().toString() 형식으로 사용 가능하지만
		 * NullPointerException이 발생 할 수 있으므로 문자열 형변환 사용 권장
		 */

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		UserVO userVO = userDao.findById(username);

		if (userVO == null) {
			throw new UsernameNotFoundException("회원가입 필요");
		}

		if (userVO.getPassword().equals(password)) {
			throw new BadCredentialsException("비밀번호 오류");
		}

		List<AuthorityVO> authList = userDao.select_role(username);
		List<GrantedAuthority> grantList = new ArrayList<>();

		for (AuthorityVO vo : authList) {
			grantList.add(new SimpleGrantedAuthority(vo.getAuthority()));
		}

		userVO.setAuthorities(grantList);

		/*
		 * 사용자 이름과 비밀번호, 권한 리스트로 Token 발행
		 */

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userVO, null, grantList);

		return token;
	}

	/*
	 * security에서 인증 절차를 수행하기 위하여 AuthenticationProvider를 상속받으면
	 * 반드시 supports를 true로 만들어주어야 한다 
	 */

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
