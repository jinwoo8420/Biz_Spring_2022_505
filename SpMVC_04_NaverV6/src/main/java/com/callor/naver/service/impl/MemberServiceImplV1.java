package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.MemberVO;
import com.callor.naver.service.MemberService;

@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService {

	@Override
	public List<MemberVO> findByName(String name) {
		return null;
	}

	@Override
	public List<MemberVO> findByTel(String tel) {
		return null;
	}

	@Override
	public MemberVO findByEmail(String email) {
		return null;
	}

	@Override
	public MemberVO findByEmailAndTel(String email, String tel) {
		return null;
	}

	@Override
	public List<MemberVO> selectAll() {
		return null;
	}

	@Override
	public MemberVO findById(String id) {
		return null;
	}

	@Override
	public int insert(MemberVO vo) {
		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

}
