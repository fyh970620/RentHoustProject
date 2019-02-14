package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.bean.JsonModel;

public interface HouseBiz {
	
	/**
	 * 添加房屋
	 * @param house
	 * @return
	 */
	public boolean addHouse(House house);
	
	/**
	 * 更新房屋
	 * @param house
	 * @return
	 */
	public boolean updateHouse(House house);
	
	/**
	 * 删除房屋
	 */
	public boolean delHouse(Integer id);
	
	/**
	 * 分页查询
	 */
	public JsonModel<House> searchHouse(Map<String,Object> map );
	
	/**
	 * 根据id查房屋
	 */
	public House getHouseBean(House hb);
	
	/**
	 * 批量删除
	 */
	public boolean delHouses(List<Integer> ids);
	
	
	
	
}
