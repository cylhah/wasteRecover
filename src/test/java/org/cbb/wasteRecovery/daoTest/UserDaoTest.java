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

        User user1=userDao.selectByPhoneAndPass(user);
        System.out.println(user1);
    }



    @Test
    public void updateData() throws Exception{

        User user=new User();

        userDao.updateData(user);
    }
}
