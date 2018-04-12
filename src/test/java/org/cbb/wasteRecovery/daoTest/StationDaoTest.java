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
        /**
         * Preparing: select t.staid,t.password,t.username, st.name,st.address,st.detailed_address, c.realName,c.sex,c.password,c.phoneNumber,c.photo,c.idCardNum,c.idCardFrontPhoto,c.idCardBackPhoto,c.createTime,c.avater,c.staid,c.state,c.volume from ( station st LEFT JOIN consultant t ON st.id=t.staid ) LEFT JOIN collector c ON st.id=c.staid where st.id=?
         * Parameters: 2(Integer)
         *  Total: 1
         * Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节',
         * locationX=91.3211, locationY=89.9999, collectorList=[], consultantList=[]}
         */

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
        /**
         * Preparing: insert into station(name,address,detailed_address,position) values (?,?,?,point(?,?))
         * Parameters: 测试站(String), 测试地址(String), 测试细节(String), 89.452(Double), 89.334(Double)
         * Updates: 1
         */

        String name="测试站";;
        String address="测试地址";
        String detailed_address="测试细节";
        double locationX=89.452;
        double locationY=89.334;
        int i=stationDao.insertStaion(name,address,detailed_address,locationX,locationY);
        System.out.println(i);

    }


    @Test
    public void deleteStation() throws Exception{
        /**
         * Preparing: delete from station where id=?
         * Parameters: 3(Integer)
         * Updates: 1
         */
        int i=stationDao.deleteStation(3);
        System.out.println(i);
    }


    @Test
    public void updateData() throws Exception{
        /**
         * Preparing: update station set name = ?, address = ?, detailed_address = ?, position=point(?,?) where id = ?
         * Parameters: 更改测试(String), 更改地址(String), 更改细节(String), 91.3211(Double), 89.9999(Double), 2(Integer)
         * Updates: 1
         */

        Station station=new Station();

        station.setId(2);

        station.setName("更改测试");
        station.setAddress("更改地址");
        station.setDetailed_address("更改细节");
        station.setLocationX(91.3211);
        station.setLocationY(89.9999);
        int i=stationDao.updateData(station);
        System.out.println(i);
    }
}
