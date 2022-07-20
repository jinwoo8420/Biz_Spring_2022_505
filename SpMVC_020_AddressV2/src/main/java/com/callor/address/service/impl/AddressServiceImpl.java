package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.persistance.AddressDao;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.ADDR_V1)
public class AddressServiceImpl implements AddressService {

	/*
	 * Service interface에서 Dao를 상속받고 있는 상태에서
	 * ServiceImpl 클래스에서 Dao를 생성자로 주입받는 경우
	 * 생성자에서 오류가 발생하는 경우가 있다 => circular reference : 무한 반복 주입 오류, 순환참조 오류
	 * 이 오류가 발생하는 경우 생성자 주입 대신 setter 주입으로 변경하면
	 * 오류가 발생하지 않는다
	 * 
	 * 	private AddressDao addrDao;
		public AddressServiceImpl() { }
	 */

	private final AddressDao addrDao;

	public AddressServiceImpl(AddressDao addrDao) {
		this.addrDao = addrDao;
	}

	@Override
	public List<AddressVO> selectAll() {
		return addrDao.selectAll();
	}

	@Override
	public AddressVO findById(Long seq) {
		return addrDao.findById(seq);
	}

	@Override
	public int insert(AddressVO address) {
		return addrDao.insert(address);
	}

	@Override
	public int update(AddressVO address) {
		addrDao.update(address);
		return 0;
	}

	@Override
	public int delete(Long seq) {
		addrDao.delete(seq);
		return 0;
	}

	/*
	 * Dao와 같은 이름의 method를 호출하면
	 * circular reference 오류가 발생하는 경우가 있다
	 * 그럴 경우는 별도의 method를 만들어 사용한다
	 */

	@Autowired
	@Override
	public void create_addr_table() {
		addrDao.create_addr_table();
	}

	/*
	 * search 문자열이 null일 경우 전체 데이터를 조회 할 수 있도록 만드는 코드를
	 * Controller에서 Service로 이동
	 */

	@Override
	public List<AddressVO> searchAndPage(SearchPage searchpage) {
		return addrDao.searchAndPage(searchpage);
	}

	// 한 페이지에 보여질 데이터 리스트 개수
	private static final long LIST_PER_PAGE = 10;
	// 화면 하단에 페이지 번호 출력
	private static final long PAGE_NO_COUNT = 10;

	/*
	 * 조건에 맞는 데이터를 가져와서 pagenation을 그리기 위한 SearchPage 클래스의 데이터 만들기
	 */

	@Override
	public void searchAndPage(Model model, SearchPage searchpage) {
		// pagenation 구현을 위해 전체 데이터 개수를 임시로 세팅
		searchpage.setOffset(0);
		searchpage.setLimit(addrDao.selectAll().size());

		/*
		 * 검색어가 없이 요청 할 경우 SearchPage 객체의 search 값이 null이 되어 데이터가 검색이 되지 않는다
		 * 그래서 SearchPage 객체의 search 변수 값을 ""으로 세팅
		 */
		String search = searchpage.getSearch();
		search = search == null ? "" : search;
		searchpage.setSearch(search);

		// 검색어 조건에 맞는 모든 데이터를 select
		List<AddressVO> addrList = addrDao.searchAndPage(searchpage);

		// 화면 하단의 페이지 번호 자동 계산하기 위함
		long totalCount = addrList.size();

		if (totalCount < 1)
			return;

		// 전체 데이터의 총 페이지 수 = 전체 데이터 개수를 한 페이지에 보여질 데이터 개수로 나누기
		long finalPageNo = totalCount / LIST_PER_PAGE;

		// 화면 하단의 페이지 번호를 클릭 시 전달되는 값
		long currentPageNo = searchpage.getCurrentPageNo();

		// 삼항 연산자
		currentPageNo = currentPageNo > 1 ? currentPageNo > finalPageNo ? finalPageNo : currentPageNo : 1;

		// if문
//		if (currentPageNo > finalPageNo) {
//			currentPageNo = finalPageNo;
//		}
//
//		if (currentPageNo < 1) {
//			currentPageNo = 1;
//		}

		// 선택된 페이지 번호에 따라 화면 하단 번호 리스트를 유동적으로 보여주기 위한 연산
		long startPageNo = (currentPageNo / PAGE_NO_COUNT) * PAGE_NO_COUNT;
		startPageNo = startPageNo < 1 ? 1 : startPageNo;

		long endPageNo = startPageNo * PAGE_NO_COUNT;
		endPageNo = endPageNo > finalPageNo ? finalPageNo : endPageNo;

		searchpage.setStartPageNo(startPageNo);
		searchpage.setEndPageNo(endPageNo);
		searchpage.setLimit(LIST_PER_PAGE);
		searchpage.setOffset((currentPageNo - 1) * PAGE_NO_COUNT);
		searchpage.setFinalPageNo(finalPageNo);

		// JSP로 보내기 위해 Model에 담기
		model.addAttribute("PAGE", searchpage);
	}

}
