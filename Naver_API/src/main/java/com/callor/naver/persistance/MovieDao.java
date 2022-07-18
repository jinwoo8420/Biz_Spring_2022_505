package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.MovieVO;

public interface MovieDao extends GenericDao<MovieVO, String> {

	public List<MovieVO> findByTitle(String title);

	public List<MovieVO> findBydirector(String director);

	public List<MovieVO> findBysubtitle(String subtitle);

	public List<MovieVO> findByUser(String username);

	public void create_movie_table();
}
