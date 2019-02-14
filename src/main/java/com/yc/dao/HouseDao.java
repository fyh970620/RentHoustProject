package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;

public interface HouseDao {
	
	/**
	 * 添加房屋
	 * @return
	 */
	public House addHouse(House house);
	
	/**
	 * 更新房屋
	 */
	public House updateHouse(House house);
	
	/**
	 * 删除房屋
	 */
	public boolean delHouse(Integer id);
	
	/**
	 * 查询<带排序,分页>
	 */
	public List<House> findList(Map<String, Object> map);
	
	/**
	 * 数量查询
	 */
	public int getCount(Map<String,Object> map);
	
	/**
	 * id查房
	 */
	public House findByid(House hs);
	
	/**
	 * 批量删除
	 */
	public boolean delHouses(List<Integer> ids);

	
	
}
