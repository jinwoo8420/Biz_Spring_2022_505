package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.naver.model.EncycVO;
import com.callor.naver.persistance.EncycDao;
import com.callor.naver.service.EncycService;

@Service
public class EncycServiceImpl implements EncycService {

	@Autowired
	private EncycDao encycDao;

	@Override
	public List<EncycVO> findByTitle(String title) {
		return null;
	}

	@Override
	public List<EncycVO> findByUser(String username) {
		List<EncycVO> encyc = encycDao.findByUser(username);
		return encyc;
	}

	@Bean
	public void create_encyc_table() {
		encycDao.create_encyc_table();
	}

	@Override
	public List<EncycVO> selectAll() {
		List<EncycVO> movies = encycDao.selectAll();
		return movies;
	}

	@Override
	public EncycVO findById(String id) {
		EncycVO encycVO = encycDao.findById(id);
		return encycVO;
	}

	@Override
	public int insert(EncycVO vo) {
		int ret = encycDao.insert(vo);
		return ret;
	}

	@Override
	public int update(EncycVO vo) {
		encycDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		encycDao.delete(id);
		return 0;
	}

}
