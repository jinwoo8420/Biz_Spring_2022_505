package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.model.NewsVO;
import com.callor.naver.service.NewsService;

@Service("newServiceV1")
public class NewsServiceImplV1 implements NewsService {

	@Override
	public List<NewsVO> findByTitle(String title) {
		return null;
	}

	@Override
	public List<NewsVO> selectAll() {
		return null;
	}

	@Override
	public NewsVO findById(String id) {
		return null;
	}

	@Override
	public int insert(NewsVO vo) {
		return 0;
	}

	@Override
	public int update(NewsVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

}
