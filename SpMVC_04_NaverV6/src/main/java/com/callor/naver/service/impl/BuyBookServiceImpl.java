package com.callor.naver.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.persistance.BuyBookDao;
import com.callor.naver.service.BuyBookService;

@Service
public class BuyBookServiceImpl implements BuyBookService {

	@Autowired
	protected BookDao bookDao;

	@Autowired
	protected BuyBookDao buyDao;

	@Override
	public List<BuyBookVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBookVO> findByIsbnAndUserName(String isbn, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBookVO> findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBookVO> findByUserName(String username) {
		return buyDao.findByUserName(username);
	}

	// 사용 X
	@Override
	public int insert(BuyBookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create_buy_table() {
		// TODO Auto-generated method stub

	}

	/*
	 * userVO와 bookVO에 담긴 데이터를 기준으로 tbl_books 데이터와 tbl_buybooks 데이터 추가
	 * 만약 tbl_books table에 이미 같은 ISBN이 있으면 update 수행
	 */

	@Transactional
	@Override
	public int insert(UserVO userVO, BookVO bookVO) {
		// isbn에 해당하는 도서 찾기
		BookVO resultBook = bookDao.findById(bookVO.getIsbn());

		if (resultBook == null) { // 없을 시
			bookDao.insert(bookVO);
		} else { // 있을 시
			bookDao.update(bookVO);
		}

		// 구입한 도서정보를 tbl_buybooks에 추가하기

		// 1. 구입 일자 자동 생성
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		BuyBookVO buyBookVO = BuyBookVO.builder().b_date(dateFormat.format(date)).b_isbn(bookVO.getIsbn())
				.b_username(userVO.getUsername()).build();

		buyDao.insert(buyBookVO);

		return 0;
	}

}
