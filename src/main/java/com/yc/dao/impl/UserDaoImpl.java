package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.Users;
import com.yc.dao.UserDao;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    super.setSqlSessionTemplate(sqlSessionTemplate);
	  }
	
	@Override
	public boolean Register(Users user) {
		int result = super.getSqlSession().insert("com.yc.mapper.UserDaoMapper.addUser",user );
		if(result>0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Users login(Users user) {
		int result = super.getSqlSession().insert("com.yc.mapper.UserDaoMapper.loginUser",user);
		if(result!=0){
			return user;
		}else{
			System.out.println("此用户不存在");
			return null;
		}
	}
	
	
	@Override
	public Users getUserById(Integer id) {
		Users user = super.getSqlSession().selectOne("com.yc.mapper.UserDaoMapper.findbyId", id);
		return user;
	}

	@Override
	public boolean validate(Users user) {
		int result = super.getSqlSession().selectOne("com.yc.mapper.UserDaoMapper.isExist", user);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查id
	 */
	@Override
	public int getIdByName(String username) {
		Integer id = super.getSqlSession().selectOne("com.yc.mapper.UserDaoMapper.findId", username);
		return id;
		
	}

}
