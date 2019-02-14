package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.bean.HouseType;
import com.yc.biz.HouseTypeBiz;
import com.yc.dao.HouseTypeDao;

@Service
public class HouseTypeBizImpl implements HouseTypeBiz {

	private HttpSession session;
	
	@Resource(name="houseTypeDaoImpl")
	private HouseTypeDao houseTypeDao;
	
	@Override
	public List<HouseType> getAllType() {
		List<HouseType> list = houseTypeDao.selectAll();
		return list;
	}

}
