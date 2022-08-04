package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.persistance.UserDao;

@Service
public class BeanServiceImpl {

	@Autowired
	private UserDao userDao;

	/*
	 * XML이 아닌 JAVA에서 Bean 생성
	 */

	@Bean("passwordEncoder")
	public PasswordEncoder getPassword() {

		return new BCryptPasswordEncoder();
	}

	/*
	 * UserServiceImpl에서 table을 생성하는 SQL문을 호출하면
	 * @Transaction과 충돌하는 현상이 발생하여
	 * 별도 클래스로 method를 분리하였다
	 */

	@Bean
	public void create_table() {
		userDao.create_user_table();
		userDao.create_author_table();
	}
}
