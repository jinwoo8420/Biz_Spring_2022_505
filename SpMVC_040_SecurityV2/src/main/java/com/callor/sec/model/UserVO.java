package com.callor.sec.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Security에서 제공하는 사용자 정보를 담을 VO 생성
 * UserDetails 인터페이스를 상속받아 사용
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserVO implements UserDetails {
	private String username;
	private String password;
	private boolean isEnabled;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentailNonExpired;
	private Collection<? extends GrantedAuthority> authorites;
}
