package org.cbb.wasteRecovery.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AdministratorDaoTest {

	 @Resource
	 private AdministratorDao administratorDao;
	 
	 @Resource
	 private Administrator administrator;
	
	@Test
	public void selectAdmin() throws Exception{
		
	}
	
	@Test
	public void insertAdmin() throws Exception{
		administratorDao.insertAdmin(1,'qw','bc');
		
	}
	
	@Test
	public void updatePassword() throws Exception{
		
	}
	
	
}
