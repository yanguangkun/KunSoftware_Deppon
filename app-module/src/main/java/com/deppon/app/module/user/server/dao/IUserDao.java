package com.deppon.app.module.user.server.dao;

import java.util.List;

import com.deppon.app.module.user.shared.domain.UserEntity;

public interface IUserDao {

	 List<UserEntity> queryAll(UserEntity user);
}
