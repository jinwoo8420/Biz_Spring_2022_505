package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.persistance.AddressDao;
import com.callor.address.service.AddressService;

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

}
