package com.yc.web.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.District;
import com.yc.bean.JsonModel;
import com.yc.bean.Street;
import com.yc.biz.StreetBiz;

@Controller
public class StreetController {
	
	@Resource(name="streetBizImpl")
	private StreetBiz streetBiz;
	
	@ResponseBody
	@RequestMapping("street_list.action")
	public String street_list(District district) throws UnsupportedEncodingException{
		//根据 区id 取出对应的所有的街道
		System.out.println(district.getId());
		List<Street> list = streetBiz.getStreetByDistrictId(district.getId());
		System.out.println("=============>streetList" + list);
		System.out.println(list);
		JsonModel jm = new JsonModel();
		for (Street str : list) {
			str.setName(java.net.URLEncoder.encode(str.getName(),"utf-8"));;
		}
		jm.setRows(list);
		Gson g = new Gson();
		String s =g.toJson(jm);
		System.out.println(">>>>>>>>>>>+"+s);
		return s;
	}
	
}
