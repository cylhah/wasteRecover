package org.cbb.wasteRecovery.daoTest;



import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;
import org.cbb.wasteRecovery.dao.AdministratorDao;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class AdministratorDaoTest {

	 @Resource
	 private AdministratorDao administratorDao;
	 
	@Test
	public void insertAdmin() throws Exception{
		Administrator administrator=new Administrator();
		int id=2;
//		administrator.setStaid(id);
		administrator.setUsername("qw");
		administrator.setPassword("er");
		administrator.setStaid(1);
		administratorDao.insertAdmin(administrator);
		
	}
	
	@Test
	public void selectAdmin() throws Exception{
		Administrator administrator=new Administrator();
		administrator.setUsername("qw");
		administrator.setPassword("er");
		List<Administrator> administrator1=administratorDao.selectAdmin(administrator);
		for(Administrator administrator2:administrator1)
		{
			System.out.println(administrator2);
		}
		
	}
	
	
	
	@Test
	public void updatePassword() throws Exception{
		Administrator administrator=new Administrator();
		administrator.setUsername("qw");
		administrator.setPassword("zx");;
		administrator.setId(15);
		administratorDao.updatePassword(administrator);
	}

	public AdministratorDaoTest() {
		// TODO Auto-generated constructor stub
	}
	
}