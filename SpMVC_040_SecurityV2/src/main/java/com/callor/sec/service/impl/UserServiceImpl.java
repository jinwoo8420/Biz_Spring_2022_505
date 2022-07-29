package com.callor.sec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;
import com.callor.sec.persistance.UserDao;
import com.callor.sec.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

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

		// vo에 담긴 password를 BCrypt 암호화 방식으로 암호화 처리
		String encPassword = passwordEncoder.encode(vo.getPassword());
		vo.setPassword(encPassword); // 암호화 된 password를 다시 vo에 저장

		userDao.roleInsert(authList);

		return userDao.insert(vo);
	}

	/*
	 * Security에서 Update 수행하기
	 * 1. 사용자 정보를 findById()해서 가져옴
	 * 2. DB에 저장된 비밀번호와 입력한 비밀번호가 일치하는지 확인
	 * => 만약 일치할지 않으면 되돌려 보내기
	 * 3. 일치한다면 Update 수행
	 */

	@Override
	public int update(UserVO vo) {

		// 사용자 정보 DB에서 가져오기
		UserVO getUser = userDao.findById(vo.getUsername());

		// 비밀번호 일치 확인
		if (passwordEncoder.matches(vo.getPassword(), getUser.getPassword()) == false) {
			return -1;
		}

		// 비밀번호 변경을 막기 위해 DB에서 가져온 비밀번호로 다시 세팅
		vo.setPassword(getUser.getPassword());
		int ret = userDao.update(vo);

		// 로그인된 사용자의 로그인 정보를 갱신하기

		// 1. 현재 로그인된 정보를 get
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// 2. 로그인 정보에서 Role 정보 수집
		List<GrantedAuthority> grantList = new ArrayList<>(auth.getAuthorities());

		// 3. 새로운 로그인 정보 생성
		Authentication newAuth = new UsernamePasswordAuthenticationToken(vo, null, grantList);

		// 4. SecurityContext에 Update
		SecurityContextHolder.getContext().setAuthentication(newAuth);

		return ret;
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
		return userDao.roleSelect(username);
	}

}
