package com.yc.web.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.District;
import com.yc.bean.House;
import com.yc.bean.HouseType;
import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseBiz;
import com.yc.biz.HouseTypeBiz;

@Controller
public class HouseController {
		
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	@Resource(name="houseTypeBizImpl")
	private HouseTypeBiz houseTypeBiz;
	@Resource(name="districtBizImpl")
	private DistrictBiz districtBiz;
	
	@RequestMapping("house_list.action")
	public String houseList(HttpServletRequest request,@RequestParam(name="pages") Integer pages,@RequestParam(name="pagesize")Integer pagesize,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer start = (pages-1)*pagesize;
		List<HouseType> list = houseTypeBiz.getAllType();
		map.put("start", start);
		map.put("pagesize", pagesize);
		map.put("pages", pages);
		
		/*System.out.println(">>>>>>>>>>>>>>>>>>map=" + map);*/

		JsonModel<House> jm = new JsonModel();
		jm = houseBiz.searchHouse(map);
		
		request.setAttribute("jsonModel",jm);
		session.setAttribute("list", jm.getRows());
		System.out.println(jm);
		return "showList";
	}
	
	@RequestMapping("/user/house_toAdd.action")
	public String houseToAdd(HttpSession  session ){
		List<HouseType> list = houseTypeBiz.getAllType();
		System.out.println("houseTypeList============>" + list);
		session.setAttribute("houseTypeList", list);
		
		
		List<District> list2 = districtBiz.getDistrictList();
		System.out.println("districtList===========>" + list2);
		session.setAttribute("districtList", list2);
		
		session.setAttribute("TOKEN", 1);
		
		return "add";
	}
	
	@RequestMapping("/user/house_doAdd.action")
	public String houseDoAdd(House house,HttpSession  session) throws UnsupportedEncodingException{
		//获得当前添加者的id
		if( session.getAttribute("TOKEN")!=null){
			Users users = (Users) session.getAttribute("users");
			Integer id =  (Integer) session.getAttribute("id");
			users.setId(id);
		
			
			house.setUsers(users);
			
			boolean result = houseBiz.addHouse(house);
			System.out.println(house);
			System.out.println("addHouse==============>" + result);
			session.removeAttribute("TOKEN");
			session.setAttribute("TOKEN", null);
		}
		
		return "list";
	}
	
	@ResponseBody
	@RequestMapping("/user/house_del.action")
	public String houseDel(@RequestParam Integer id){
		boolean result = houseBiz.delHouse(id);
		JsonModel jm = new JsonModel();
		if(result){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		Gson gson = new Gson();
		String jsonToString = gson.toJson(jm);

		return jsonToString;
		
	}
	
	@RequestMapping("/user/house_ToUpdate.action")
	public String houseToUpdate(@RequestParam Integer id,HttpSession session,HttpServletRequest request){
		List<House> list = (List<House>) session.getAttribute("list");
		for(House house : list){
			if(house.getId() == id){
				request.setAttribute("house",house);
				request.setAttribute("house.id", id);
				break;
			}
		}		
		return "update";	
	}
	
	@RequestMapping("/user/house_DoUpdate.action")
	public String houseDoUpdate(House house,HttpSession session,HttpServletRequest request){
		Users users = (Users) session.getAttribute("users");
		Integer id = (Integer) session.getAttribute("id");
		Integer house_id = (Integer) request.getAttribute("id");
		users.setId(id);
		house.setUsers(users);
		house.setId(house_id);
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\" + house.getId());
		boolean result = houseBiz.updateHouse(house);
		
		return "list";
		
	}
	
	
	
}
