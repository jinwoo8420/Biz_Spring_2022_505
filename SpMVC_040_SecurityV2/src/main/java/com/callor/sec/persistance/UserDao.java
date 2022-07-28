package com.callor.sec.persistance;

import com.callor.sec.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {
	public void create_user_table();

	public void create_author_table();
}
