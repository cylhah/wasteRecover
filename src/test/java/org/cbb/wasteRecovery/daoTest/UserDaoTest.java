package org.cbb.wasteRecovery.daoTest;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.UserDao;
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

    @Test
    public void insertUser() throws Exception{
        User user=new User();
        user.setName("江铮");
        user.setSex('男');
        user.setPassword("root");
        user.setPhoneNumber("13867888450");
        user.setAvater("0i");
        user.setBankAccount("02055");
        user.setEmail("10047012@qq.com");

        userDao.insertUser(user);
    }

    @Test
    public void selectById() throws Exception{

        User user= userDao.selectById(1);
        System.out.println( user);
    }

    @Test
    public void selectByPhoneNumber() throws Exception{

        User user= userDao.selectByPhoneNumber("13957863999");
        System.out.println(user);
    }

    @Test
    public void selectByPhoneAndPass() throws Exception{
        User user=new User();
        user.setPassword("roott");
        user.setPhoneNumber("13957863999");
        User user1=userDao.selectByPhoneAndPass(user);
        System.out.println(user1);
    }



    @Test
    public void updateData() throws Exception{

        User user=new User();
        user.setId(1);
        user.setName("江柳萍");
        user.setSex('女');
        user.setPhoneNumber("13845888450");
        user.setBankAccount("0255");
        user.setEmail("1004745012@qq.com");
        userDao.updateData(user);
    }
}
