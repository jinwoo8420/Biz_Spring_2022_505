package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.model.BookVO;
import com.callor.naver.service.BookService;

@Service("bookServiceV1")
public class BookServiceImplV1 implements BookService {

	@Override
	public List<BookVO> findByTitle(String title) {
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		return null;
	}

	@Override
	public List<BookVO> findByPublisher(String publisher) {
		return null;
	}

	@Override
	public List<BookVO> findByPrice(int price) {
		return null;
	}

	@Override
	public List<BookVO> selectAll() {
		return null;
	}

	@Override
	public BookVO findById(String id) {
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		return 0;
	}

	@Override
	public int update(BookVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

}
