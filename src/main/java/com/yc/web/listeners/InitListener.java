package com.yc.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitListener implements ServletContextListener{
	
	private ApplicationContext ac;
	
	public InitListener(){
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/*ServletContext application = sce.getServletContext();
		ac = WebApplicationContextUtils.getWebApplicationContext(application);
		HouseTypeBiz typeBiz = (HouseTypeBiz)ac.getBean("typeBizImpl");
		List<HouseType> houseTypeList = typeBiz.getTypeList();
		application.setAttribute("houseTypeList",houseTypeList);
		DistrictBiz districtBiz = (DistrictBiz)ac.getBean("districtBizImpl");
		List<District> districtList = districtBiz.getDistrictList();
		application.setAttribute("districtList",districtList);
		*/
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	
	
}
