package org.cbb.wasteRecovery.daoTest;

import org.cbb.wasteRecovery.dao.CollectorDao;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@RunWith(value =SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration(value ="classpath:spring/spring-dao.xml")
public class CollectorDaoTest {

	@Resource
	 private CollectorDao collectorDao;
	
	@Test
	public void selectById() throws Exception{
		
	}

}
