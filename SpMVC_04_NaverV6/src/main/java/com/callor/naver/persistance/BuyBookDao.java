package com.callor.naver.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.naver.model.BuyBookVO;

/*
 * 데이터 조회 method를 구현 할 때
 * PK(findById)를 기준으로 조회하는 method는 return type을 VO를 사용한다
 * PK가 아닌 칼럼을 기준으로 조회를 할 때는 데이터가 1개만 있을 것이라는 보장이 없기 때문에
 * return type을 반드시 List<VO>를 사용해야 한다
 */

public interface BuyBookDao {
	public List<BuyBookVO> selectAll();

	/*
	 * mapper와 연동 할 때 mapper에게 전달하는 변수가 2개 이상일때는
	 * 각각의 변수에 @Param 속성을 지정해 주어야한다
	 * 그렇지 않으면 mapper가 어떤 변수에 데이터가 담겨있는지 혼동 가능성 존재
	 */
	
	public List<BuyBookVO> findByIsbnAndUserName(@Param("isbn") String isbn, @Param("username") String username);

	public List<BuyBookVO> findByIsbn(String isbn);

	public List<BuyBookVO> findByUserName(String username);

	public int insert(BuyBookVO vo);

	public void create_buy_table();
}
