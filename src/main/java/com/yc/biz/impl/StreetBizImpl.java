package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Street;
import com.yc.biz.StreetBiz;
import com.yc.dao.StreetDao;

@Service
public class StreetBizImpl implements StreetBiz {

	@Resource(name="streetDaoImpl")
	private StreetDao streetDao;
	
	@Override
	public List<Street> getStreetByDistrictId(Integer id) {
		List<Street> list = streetDao.ListDisToStr(id);
		return list;
	}

}
