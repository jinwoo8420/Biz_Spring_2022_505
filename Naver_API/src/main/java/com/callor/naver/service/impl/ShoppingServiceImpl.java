package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.model.ShoppingVO;
import com.callor.naver.persistance.ShoppingDao;
import com.callor.naver.service.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private ShoppingDao shoppingDao;

	@Override
	public List<ShoppingVO> findByTitle(String title) {
		return null;
	}

	@Override
	public List<ShoppingVO> findByMaker(String maker) {
		return null;
	}

	@Override
	public List<ShoppingVO> findByBrand(String brand) {
		return null;
	}

	@Autowired
	@Override
	public void create_shopping_table() {
		try {
			shoppingDao.create_shopping_table();
		} catch (Exception e) {
		}
	}

	@Override
	public List<ShoppingVO> selectAll() {
		List<ShoppingVO> shopping = shoppingDao.selectAll();
		return shopping;
	}

	@Override
	public ShoppingVO findById(String id) {
		ShoppingVO shoppingVO = shoppingDao.findById(id);
		return shoppingVO;
	}

	@Override
	public int insert(ShoppingVO vo) {
		int ret = shoppingDao.insert(vo);
		return ret;
	}

	@Override
	public int update(ShoppingVO vo) {
		shoppingDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		shoppingDao.delete(id);
		return 0;
	}

	@Override
	public List<ShoppingVO> findByUser(String username) {
		List<ShoppingVO> shopping = shoppingDao.findByUser(username);
		return shopping;
	}

}
