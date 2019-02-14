package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.District;
import com.yc.dao.DistrictDao;

@Repository
public class DistrictDaoImpl extends SqlSessionDaoSupport implements DistrictDao {

	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    super.setSqlSessionTemplate(sqlSessionTemplate);
	  }
	
	@Override
	public List<District> listDistricts() {
		List<District> list = super.getSqlSession().selectList("com.yc.mapper.DistrictDaoMapper.listDistricts");
		return list;
	}
	/*
	@Override
	public List ListDisToStr(Integer id) {
		List list = super.getSqlSession().selectList("com.yc.mapper.DistrictDaoMapper.DistrictToStreet", id);
		return list;
	}*/



}
