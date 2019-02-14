package com.yc.test;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 数据库测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml", "classpath*:applicationContext_dao.xml" }) 
public class Sqltest {
	
	@Resource(name="dataSource")
	private BasicDataSource dataSource;
	@Resource(name="sqlSessionFactory")
	private DefaultSqlSessionFactory SqlSessionFactoryBean;
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void test1() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void test2() {
		System.out.println(SqlSessionFactoryBean);
	}
	@Test
	public void test3() {
		System.out.println( sqlSession );
	}
}
