package com.deppon.app.module.user.server.service.impl;

import java.util.List;

import com.deppon.app.module.user.server.dao.IUserDao;
import com.deppon.app.module.user.server.service.IUserService;
import com.deppon.app.module.user.shared.domain.UserEntity;

public class UserService implements IUserService {

	private IUserDao userDao;
 
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<UserEntity> queryAll(UserEntity user) {

		return userDao.queryAll(user);
	}
	
	
}
