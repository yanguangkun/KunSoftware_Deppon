package com.deppon.app.module.user.server.service;

import java.util.List;

import com.deppon.app.module.user.shared.domain.UserEntity;
import com.deppon.foss.framework.service.IService;

public interface IUserService extends IService {

	List<UserEntity> queryAll(UserEntity user);
}
