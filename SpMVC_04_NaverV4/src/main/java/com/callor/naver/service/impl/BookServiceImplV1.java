package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * bookServiceV1
 * BookService interface를 상속받은 클래스가 다수 있을때
 * Controller에서 어떤 클래스를 지금 연결하여 사용 할 것인가의 문제가 발생
 * 
 * 그럴 경우 @Service Annotation(식별자)을 부착하여 클래스 중에서 필요한 부분을 선택
 */

@Slf4j
@Service(QualifierConfig.SERVICE.BOOKS_V1)
public class BookServiceImplV1 implements BookService {

	/*
	 * GenericDao를 상속받아 BookDao를 만들고
	 * BookDao를 상속받아 BookService를 만들었다
	 * 이러한 다중상속관계에서 BookDao를 사용하여 서비스를 구현하려 한다
	 * 
	 * 보통 Dao를 설정 할 때 private final로 선언하고
	 * 생성자에서 주입받아 사용했다
	 * 
	 * 그런데 다중상속관계에서 각각의 상속이 얽히면서 무한 반복 구조가 만들어질 수 있다
	 * 이때는 생성자 주입을 할 수 없고 setter 주입(@Autowired)을 사용해야 한다
	 */

	@Autowired
	private BookDao bookDao;

	/*
	 * Spring에서 자동화 된 코드를 실행하고 싶을 때 method를 만들고 method에 @Autowired를 설정해두면
	 * 
	 */

	@Autowired
	@Override
	public void create_book_table() {

		/*
		 * BookDao의 create_book_table() method를 실행
		 * 만약 exception이 발생하면 무시
		 */

		try {
			/*
			 * Dao에 create table SQL을 작성하고
			 * Service 클래스에 Autowired 된 method를 선언하고
			 * 자동으로 실행되도록 한다
			 */

			log.debug("TABLE 생성");
			bookDao.create_book_table();
		} catch (Exception e) {
			log.debug("TABLE 생성 X");
		}
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
	public List<BookVO> findByPrice(int price) {
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
		/*
		 * MyBatis에서 DB에 INSERT를 수행하고 나면
		 * INSERT 된 데이터의 행 개수를 return 한다
		 * 만약 return 된 값이 0이라면 한개의 데이터도 INSERT 하지 못한 것이다
		 * 1 이상의 정수 값이 return 되면 몇개의 데이터가 INSERT 되었는지
		 * 확인 할 수 있다	
		 */

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
}
