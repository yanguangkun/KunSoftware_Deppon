package com.deppon.app.module.user.server.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.app.module.user.server.service.IUserService;
import com.deppon.app.module.user.shared.domain.SynUserRequest;
import com.deppon.app.module.user.shared.ws.ISynUserService;

public class SynUserService implements ISynUserService {

	private static final Logger logger = LoggerFactory.getLogger(SynUserService.class);

	private IUserService appUserService;
	
	@Override
	public String getName(SynUserRequest name) {

		logger.info(name.getName());
		return name.getName();
	}

	public IUserService getAppUserService() {
		return appUserService;
	}

	public void setAppUserService(IUserService appUserService) {
		this.appUserService = appUserService;
	}
	
}
