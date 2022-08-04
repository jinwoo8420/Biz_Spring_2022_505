package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		UserVO user = (UserVO) userService.loadUserByUsername(username);

		if (user.isEnabled() == false) {
			throw new BadCredentialsException(username + " 회원가입 절차 미완료");
		}

		/*
		 * 정상적으로 사용자가 로그인하면 인증 Token
		 */

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password,
				user.getAuthorities());

		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
