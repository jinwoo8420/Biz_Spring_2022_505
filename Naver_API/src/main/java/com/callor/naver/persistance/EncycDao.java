package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.EncycVO;

public interface EncycDao extends GenericDao<EncycVO, String> {

	public List<EncycVO> findByTitle(String title);

	public List<EncycVO> findByUser(String username);

	public void create_encyc_table();
}
