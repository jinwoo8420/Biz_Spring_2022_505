package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.model.MovieVO;
import com.callor.naver.persistance.MovieDao;
import com.callor.naver.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Override
	public List<MovieVO> findByTitle(String title) {
		return null;
	}

	@Override
	public List<MovieVO> findBydirector(String director) {
		return null;
	}

	@Override
	public List<MovieVO> findBysubtitle(String subtitle) {
		return null;
	}

	@Override
	public List<MovieVO> findByUser(String username) {
		List<MovieVO> movies = movieDao.findByUser(username);
		return movies;
	}

	@Autowired
	@Override
	public void create_movie_table() {
		try {
			movieDao.create_movie_table();
		} catch (Exception e) {
		}
	}
	
	@Autowired
	@Override
	public void create_movie_seq() {
		try {
			movieDao.create_movie_seq();
		} catch (Exception e) {
		}
	}

	@Override
	public List<MovieVO> selectAll() {
		List<MovieVO> movies = movieDao.selectAll();
		return movies;
	}

	@Override
	public MovieVO findById(String id) {
		MovieVO movieVO = movieDao.findById(id);
		return movieVO;
	}

	@Override
	public int insert(MovieVO vo) {
		int ret = movieDao.insert(vo);
		return ret;
	}

	@Override
	public int update(MovieVO vo) {
		movieDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		movieDao.delete(id);
		return 0;
	}

}
