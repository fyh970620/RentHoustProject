package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.biz.HouseBiz;
import com.yc.dao.HouseDao;

@Service
public class HouseBizImpl implements HouseBiz {
	
	@Resource(name="houseDaoImpl")
	private HouseDao houseDao;
	
	@Override
	public boolean addHouse(House house) {
		house = houseDao.addHouse(house);
		if(house!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateHouse(House house) {
		house = houseDao.addHouse(house);
		if(house!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean  delHouse(Integer id) {
		boolean result = houseDao.delHouse(id);
		return result;
		
	}

	@Override
	public JsonModel<House> searchHouse(Map<String, Object> map) {
		/*System.out.println(map);*/
		List<House> list = houseDao.findList(map);
		int total = houseDao.getCount(map);
		JsonModel<House> jm = new JsonModel<House>();
		jm.setRows(list);
		jm.setTotal(total);
		jm.setPages(Integer.parseInt(map.get("pages").toString()));
		jm.setPagesize(Integer.parseInt(map.get("pagesize").toString()));
		return jm;
	}

	@Override
	public House getHouseBean(House hb) {
		House house = houseDao.findByid(hb);
		return house;
	}


	@Override
	public boolean delHouses(List<Integer> ids) {
		boolean result = houseDao.delHouses(ids);
		return result;
	}
}













