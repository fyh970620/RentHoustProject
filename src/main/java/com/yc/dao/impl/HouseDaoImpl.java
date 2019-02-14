package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.House;
import com.yc.dao.HouseDao;

@Repository
public class HouseDaoImpl extends SqlSessionDaoSupport implements HouseDao {
	
	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    super.setSqlSessionTemplate(sqlSessionTemplate);
	  }
	
	@Override
	public House addHouse(House house) {
		int result = super.getSqlSession().insert("com.yc.mapper.HouseDaoMapper.addHouse", house);
		if(result != 0){
			return house;
		}else{
			return null;
		}
	}

	@Override
	public House updateHouse(House house) {
		int result = super.getSqlSession().update("com.yc.mapper.HouseDaoMapper.updateHouse", house);
		if(result != 0){
			return house;
		}else{
			return null;
		}
	}

	@Override
	public boolean delHouse(Integer id) {
		int result = super.getSqlSession().delete("com.yc.mapper.HouseDaoMapper.delHouse", id);
		if(result!=0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<House> findList(Map<String, Object> map) {
		System.out.println(super.getSqlSession()+">>>>>>>>>>>>>>>>>>>.");
		List<House> list  = super.getSqlSession().selectList("com.yc.mapper.HouseDaoMapper.selectHouseCondition", map);
		return list;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		int count = super.getSqlSession().selectOne("com.yc.mapper.HouseDaoMapper.selectHouseConditionCount", map);
		return count;
	}

	@Override
	public House findByid(House hs) {
		House house = super.getSqlSession().selectOne("com.yc.mapper.HouseDaoMapper.findByid", hs);
		return house;
	}

	@Override
	public boolean delHouses(List<Integer> ids) {
		int result = super.getSqlSession().delete("com.yc.mapper.HouseDaoMapper.delMoreHouse", ids);
		if(result != 0){
			return true;
		}else{
			return false;
		}
	}

	

}
