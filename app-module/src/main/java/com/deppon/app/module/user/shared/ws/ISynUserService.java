package com.deppon.app.module.user.shared.ws;

import javax.jws.WebService;

import com.deppon.app.module.user.shared.domain.SynUserRequest;

@WebService
public interface ISynUserService {

	String getName(SynUserRequest name);
}
