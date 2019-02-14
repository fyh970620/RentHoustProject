package com.yc.dao;

import java.util.List;

import com.yc.bean.District;

public interface DistrictDao {
	
	/**
	 * 查所有的区
	 * @return
	 */
	public List<District> listDistricts();
	
	/*
	public List ListDisToStr(Integer id);*/
	
}
