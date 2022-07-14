package com.callor.naver.service;

import java.util.List;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BuyBookDao;

public interface BuyBookService extends BuyBookDao {
	public int insert(UserVO userVO, BookVO bookVO);

	public List<String> findByDate();

	public List<BuyBookVO> findByUserNameAndDate(String username, String buydate);
}
