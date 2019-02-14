package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.DistrictBiz;
import com.yc.dao.DistrictDao;

@Service
public class DistrictBizImpl implements DistrictBiz {

	@Resource(name="districtDaoImpl")
	private DistrictDao districtDao;
	
	@Override
	public List<District> getDistrictList() {
		List<District> list = districtDao.listDistricts();
		return list;
	}
	/*
	@Override
	public List<Street> getStreetByDistrictId(Integer id) {
		List<Street> list = districtDao.ListDisToStr(id);
		return list;
	}*/
	
	

}
