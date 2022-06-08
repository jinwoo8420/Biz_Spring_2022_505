package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.NewsVO;

/*
 * Generic Dao를 상속받음으로써 기본 CRUD method는 만들지 않아도 된다
 */

public interface NewsDao extends GenericDao<NewsVO, String> {
	public List<NewsVO> findByTitle(String title);

}
