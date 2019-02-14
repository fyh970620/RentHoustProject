package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Users;
import com.yc.biz.UserBiz;
import com.yc.dao.UserDao;

@Service
public class UserBizImpl implements UserBiz {
	
	@Resource(name="userDaoImpl")
	private UserDao userDao;
	
	@Override
	public boolean Register(Users user) {
		boolean result = userDao.Register(user);
		return result;
	}

	@Override
	public Users login(Users user) {
		user = userDao.login(user);
		return user;
	}

	@Override
	public int getId(String username) {
		Integer id = userDao.getIdByName(username);
		return id;
	}

}
