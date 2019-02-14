package com.yc.dao;

import com.yc.bean.Users;

public interface UserDao {
	
	//注册
	public boolean Register(Users user);
	
	//登录
	public Users login(Users user);
	
	/**
	 * 根据id查
	 */
	public Users getUserById(Integer id);
	
	/**
	 * 查用户是否存在
	 * @param user
	 * @return
	 */
	public boolean validate(Users user);
	
	/**
	 * 当前user的id
	 */
	public int getIdByName(String username);
	
}
