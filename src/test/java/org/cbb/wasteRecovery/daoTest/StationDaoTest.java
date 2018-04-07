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

        Station station= stationDao.selectById(2);
        System.out.println(station);
    }



    @Test
    public void selectByAdd() throws Exception{

        String address="er";
        int offset=0;
        int limit=1;
       List<Station> station= stationDao.selectByAdd(address,offset,limit);
        for(Station station1:station)
        {
            System.out.println(station1);
        }

    }

    @Test
    public void selectByName() throws Exception{

        String name="qw";
        int offset=0;
        int limit=1;
        List<Station> station= stationDao.selectByName(name,offset,limit);
        for(Station station1:station)
        {
            System.out.println(station1);
        }

    }
    @Test
    public void insertStaion() throws Exception {

        String name="qwers";;
        String address="erdfa";
        String detailed_address="zdxcv";
        double locationX=2.34;
        double locationY=4.56;
        int i=stationDao.insertStaion(name,address,detailed_address,locationX,locationY);
        System.out.println(i);

    }


    @Test
    public void deleteStation() throws Exception{




        int i=stationDao.deleteStation(1);
        System.out.println(i);
    }


    @Test
    public void updateData() throws Exception{

        Station station=new Station();

        station.setId(3);

        station.setName("ghjk");
        station.setAddress("io");
        station.setDetailed_address("rtyu");
        int i=stationDao.updateData(station);
        System.out.println(i);
    }
}
