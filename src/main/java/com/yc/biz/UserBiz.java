package com.yc.biz;

import com.yc.bean.Users;

public interface UserBiz {

	//注册
	public boolean Register(Users user);
	
	//登录
	public Users login(Users user);
	
	/**
	 * 查id
	 */
	public int getId(String username);
	
}
