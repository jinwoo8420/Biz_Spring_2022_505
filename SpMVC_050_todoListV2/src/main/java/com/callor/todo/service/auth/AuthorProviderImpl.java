package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/*
		 * getPrincipal().toString() 형식으로 사용 가능하지만
		 * NullPointerException이 발생 할 수 있으므로 문자열 형변환 사용 권장
		 */

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		if (username.equals("jinwoo8420") == false) {
			throw new UsernameNotFoundException("USERNAME 오류");
		}

		if (password.equals("1234") == false) {
			throw new BadCredentialsException("PASSWORD 오류");
		}

		UserVO userVO = UserVO.builder().username(username).password(password).email("abc@abc.abc").realname("abc")
				.nickname("1223wlsdn").build();

		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));

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
