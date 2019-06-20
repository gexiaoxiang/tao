package com.tao.portal.service;

import com.tao.pojo.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
