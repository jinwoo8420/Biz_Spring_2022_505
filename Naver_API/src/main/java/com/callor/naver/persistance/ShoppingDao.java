package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.ShoppingVO;

public interface ShoppingDao extends GenericDao<ShoppingVO, String> {
	public List<ShoppingVO> findByTitle(String title);

	public List<ShoppingVO> findByMaker(String maker);

	public List<ShoppingVO> findByBrand(String brand);
	
	public List<ShoppingVO> findByUser(String username);

	public void create_shopping_table();
}
