package com.callor.address.persistance;

import java.util.List;

import com.callor.address.model.AddressVO;

public interface AddressDao {
	public List<AddressVO> selectAll();

	public AddressVO findById(Long seq);

	public int insert(AddressVO address);

	public int update(AddressVO address);

	public int delete(Long seq);
	
	public void create_addr_table();
}
