package com.deppon.app.module.user.server.dao.impl;

import java.util.List;

import com.deppon.app.module.user.server.dao.IUserDao;
import com.deppon.app.module.user.shared.domain.UserEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UserDao extends iBatis3DaoImpl implements IUserDao {

	private final String NAMESPACE = "com.deppon.app.module.user.shared.domain.UserEntity.";
	
	@Override
	public List<UserEntity> queryAll(UserEntity user) { 
		 return getSqlSession().selectList(NAMESPACE + "queryAll",user);
	} 

}
