package com.yc.biz;

import java.util.List;

import com.yc.bean.Street;

public interface StreetBiz {
	
	public List<Street> getStreetByDistrictId(Integer id);
}
