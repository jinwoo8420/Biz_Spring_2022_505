package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.naver.model.BookVO;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Bean
	public void create_book_table() {
		bookDao.create_book_table();
	}

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
	public List<BookVO> selectAll() {
		List<BookVO> books = bookDao.selectAll();
		return books;
	}

	@Override
	public BookVO findById(String id) {
		BookVO bookVO = bookDao.findById(id);
		return bookVO;
	}

	@Override
	public int insert(BookVO vo) {
		int ret = bookDao.insert(vo);
		return ret;
	}

	@Override
	public int update(BookVO vo) {
		bookDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		bookDao.delete(id);
		return 0;
	}

	@Override
	public List<BookVO> findByUser(String username) {
		List<BookVO> books = bookDao.findByUser(username);
		return books;
	}
}
