package com.yc.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.District;
import com.yc.bean.House;
import com.yc.bean.HouseType;
import com.yc.bean.Street;
import com.yc.bean.Users;
import com.yc.dao.DistrictDao;
import com.yc.dao.HouseDao;
import com.yc.dao.StreetDao;
import com.yc.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml", "classpath*:applicationContext_dao.xml" }) 
public class DaoTest {
	
	@Resource(name="userDaoImpl")
	private UserDao userDao;
	@Resource(name="houseDaoImpl")
	private HouseDao houseDao;
	@Resource(name="districtDaoImpl")
	private DistrictDao districtDao;
	@Resource(name="streetDaoImpl")
	private StreetDao streetDao;
	
	@Test
	public void test() {
		Users user = new Users();
		user.setName("cs");
		user.setPassword("cs");
		user.setTelephone("12331132");
		user.setUsername("cs_username");
		user.setIsadmin("1");
		boolean result = userDao.Register(user);
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		Users user = new Users();
		user.setUsername("cs_username");
		user.setPassword("cs");
		userDao.login(user);
		if(userDao.login(user)!=null){
			System.out.println(userDao.login(user));
		}
	}
	
	@Test
	public void test3() {
		House house = new House();
		house.setTitle("cs3");
		house.setDescription("cs描述");
		house.setPrice(1000.0);
		house.setFloorage(100);
		house.setContact("csContact");
		Users user = new Users();
		user.setId(1);
		house.setUsers(user);
		HouseType ht = new HouseType();
		ht.setId(1);
		house.setHouseType(ht);
		Street st = new Street();
		st.setId(1000);
		house.setStreet(st);
		house = houseDao.addHouse(house);
		if(house!=null){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void test4(){
		/*List<District> list = districtDao.listDistricts();
		System.out.println(list);*/
		
		List<Street> list = streetDao.ListDisToStr(1004);
		System.out.println(list);
	}

}
