package org.cbb.wasteRecovery.daoTest;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.ScrapDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ScrapDaoTest {

    @Resource
    private ScrapDao scrapDao;

    @Test
    public void selectByTid() throws Exception{

        List<Scrap> scrap=scrapDao.selectByTid(1);
        for(Scrap scrap1:scrap)
        {
            System.out.println(scrap1);
        }

    }
}
