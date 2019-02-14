package com.yc.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.StreetBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml", "classpath*:applicationContext_dao.xml" }) 
public class BizTest {

	
	@Resource(name="streetBizImpl")
	private StreetBiz streetBiz;
	
	@Test
	public void test() {
		District district = new District();
		district.setId(1004);
		List<Street> list = streetBiz.getStreetByDistrictId(district.getId());
		System.out.println(list);
	}

}
