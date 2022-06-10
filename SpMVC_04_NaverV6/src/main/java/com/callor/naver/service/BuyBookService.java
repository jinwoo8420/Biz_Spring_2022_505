package com.callor.naver.service;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BuyBookDao;

public interface BuyBookService extends BuyBookDao {
	public int insert(UserVO userVO, BookVO bookVO);
}
