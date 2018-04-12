package org.cbb.wasteRecovery.daoTest;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.UserDao;
import org.cbb.wasteRecovery.entity.GeoHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    GeoHash geoHash=new GeoHash();

    @Test
    public void insertUser() throws Exception{


        String openId=geoHash.encode(90,90);
        int i=userDao.insertUser(openId);
        System.out.println(i);
    }

    @Test
    public void selectById() throws Exception{
        String openid="qw";
        User user=userDao.selectById(openid);
        System.out.println(user);
    }

    @Test
    public void banUser() throws Exception{
        String openid="qw";
        int i=userDao.banUser(openid);
        System.out.println(i);
    }





    @Test
    public void updateData() throws Exception{

        String openId="qwer";
        String avater="vb";
       int i= userDao.updateData(openId,avater);
        System.out.println(i);
    }

    @Test
    public void deleteUser() throws Exception{

        String openid="qw";


        int i=userDao.deleteUser(openid);
        System.out.println(i);
    }
}
