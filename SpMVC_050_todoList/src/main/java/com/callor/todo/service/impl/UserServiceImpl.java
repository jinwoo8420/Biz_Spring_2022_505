package com.callor.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.callor.todo.model.AuthorVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	@Override
	public void create_user_table() {

	}

	@Override
	public void create_author_table() {

	}

	@Override
	public List<AuthorVO> select_auths(String username) {
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	/*
	 * Transaction이 필요한 곳에 Annotation을 부착해두면
	 * Transaction이 자동으로 적용된다
	 */

	@Transactional
	@Override
	public int insert(UserVO vo) {
		List<UserVO> users = userDao.selectAll();
		List<AuthorVO> auths = new ArrayList<>();

		/*
		 * 최초 회원가입 시 ADMIN 권한 부여
		 * 그렇지 않으면 일반 USER 권한 부여
		 */

		if (users == null || users.size() < 1) {
			vo.setEnabled(true);
			auths.add(AuthorVO.builder().username(vo.getUsername()).authority("ROLE_ADMIN").build());
			auths.add(AuthorVO.builder().username(vo.getUsername()).authority("ROLE_USER").build());
		} else {
			auths.add(AuthorVO.builder().username(vo.getUsername()).authority("ROLE_USER").build());
		}

		// BCrypt 클래스를 사용하여 비밀번호 암호화
		String encPassword = passwordEncoder.encode(vo.getPassword());
		vo.setPassword(encPassword);

		userDao.role_insert(auths);

		return userDao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		userDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		userDao.delete(id);
		return 0;
	}

	@Override
	public int role_insert(List<AuthorVO> auths) {
		return 0;
	}

	/*
	 * Controller가 아닌 Service 등의 클래스에서
	 * 로그인 정보를 추출하는 방법
	 */

	public void getLoginUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserVO userVO = (UserVO) auth.getPrincipal();
	}

}
