package com.callor.sec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;
import com.callor.sec.persistance.UserDao;
import com.callor.sec.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// Bean을 생성하는 Annotation / method를 자동 실행하도록 하는 트릭
	@Bean
	public void create_table() {
		userDao.create_user_table();
		userDao.create_author_table();
	}

	@Override
	public void create_user_table() {
	}

	@Override
	public void create_author_table() {
	}

	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		List<UserVO> userList = userDao.selectAll();
		List<AuthorityVO> authList = new ArrayList<>();

		if (userList == null || userList.size() < 1) {
			/*
			 * 최초로 회원가입 시 Enabled를 true
			 * ADMIN, USER 권한 부여
			 */
			vo.setEnabled(true);

			authList.add(AuthorityVO.builder().username(vo.getUsername()).authority("ROLE_ADMIN").build());
			authList.add(AuthorityVO.builder().username(vo.getUsername()).authority("ROLE_USER").build());
		} else {
			authList.add(AuthorityVO.builder().username(vo.getUsername()).authority("ROLE_USER").build());
		}

		userDao.roleInsert(authList);

		return userDao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		return userDao.update(vo);
	}

	@Override
	public int delete(String id) {
		return userDao.delete(id);
	}

	@Override
	public int roleInsert(List<AuthorityVO> authList) {
		return 0;
	}

	@Override
	public List<AuthorityVO> roleSelect(String username) {
		return null;
	}

}
