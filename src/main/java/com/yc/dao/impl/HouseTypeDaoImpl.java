package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.HouseType;
import com.yc.dao.HouseTypeDao;

@Repository
public class HouseTypeDaoImpl extends SqlSessionDaoSupport implements HouseTypeDao {

	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    super.setSqlSessionTemplate(sqlSessionTemplate);
	  }
	
	@Override
	public List<HouseType> selectAll() {
		List<HouseType> list = super.getSqlSession().selectList("com.yc.mapper.HouseTypeDaoMapper.listAllType");
		return list;
	}

}
