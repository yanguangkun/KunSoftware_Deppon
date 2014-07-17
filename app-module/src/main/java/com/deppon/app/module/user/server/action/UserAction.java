package com.deppon.app.module.user.server.action;

import java.util.List;

import javax.annotation.Resource;

import com.deppon.app.module.user.server.service.IUserService;
import com.deppon.app.module.user.shared.domain.UserEntity;
import com.deppon.foss.framework.server.components.security.SecurityNonCheckRequired;
import com.deppon.foss.framework.server.web.action.AbstractAction;
import com.deppon.foss.framework.server.web.message.IMessageBundle;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;
import com.deppon.foss.module.frameworkimpl.server.interceptor.CookieNonCheckRequired;

public class UserAction extends  AbstractAction{
 
	private static final long serialVersionUID = 2272710551322896933L;
	

	@Resource
	private IMessageBundle messageBundle;

	private IUserService appUserService;
	
	private String message;
	private List<UserEntity> userList; 
	 

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	@JSON
	@CookieNonCheckRequired
	@SecurityNonCheckRequired
	public String queryAll() {
	        
		message = messageBundle.getMessage("dpap.app.username");
		UserEntity user = new UserEntity();
		userList = appUserService.queryAll(user);
		//message = "ok";
		setTotalCount(1L);
		return returnSuccess();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setAppUserService(IUserService appUserService) {
		this.appUserService = appUserService;
	}
	
	
}
