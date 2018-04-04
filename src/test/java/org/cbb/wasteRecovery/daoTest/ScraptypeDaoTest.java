package org.cbb.wasteRecovery.daoTest;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.ScraptypeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ScraptypeDaoTest {

    @Resource
    private ScraptypeDao scraptypeDao;

    @Test
    public void selectByid() throws Exception{

        Scraptype scraptype=scraptypeDao.selectByid(1);
        System.out.println(scraptype);
    }
}
