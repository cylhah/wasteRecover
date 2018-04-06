package org.cbb.wasteRecovery.daoTest;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.StationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class StationDaoTest {

    @Resource
    private StationDao stationDao;

    @Test
    public void selectById() throws Exception{

        Station station= stationDao.selectById(1);
        System.out.println(station);
    }

    @Test
    public void selectByPos() throws Exception{


    }

    @Test
    public void selectByAdd() throws Exception{

        List<Station> station= stationDao.selectByAdd("浙江");
        for(Station station1:station)
        {
            System.out.println(station1);
        }

    }

    @Test
    public void selectByName() throws Exception{

        List<Station> station= stationDao.selectByName("汪宏斌");
        for(Station station1:station)
        {
            System.out.println(station1);
        }

    }

    @Test
    public void updateMoney() throws Exception{

        Station station=new Station();

        station.setId(1);

    }
}
