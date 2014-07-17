package com.deppon.app.module.user.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class UserEntity extends BaseEntity{ 

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 4300481012478549457L;

	private String empCode;
	
	private String username;
	
	private String password;

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
