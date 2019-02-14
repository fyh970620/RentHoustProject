package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.Street;
import com.yc.dao.StreetDao;

@Repository
public class StreetDaoImpl extends SqlSessionDaoSupport implements StreetDao {

	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    super.setSqlSessionTemplate(sqlSessionTemplate);
	  }
	
	@Override
	public List<Street> ListDisToStr(Integer id) {
		List<Street> list = super.getSqlSession().selectList("com.yc.mapper.StreetDaoMapper.DistrictToStreet", id);
		return list;
	}

}
