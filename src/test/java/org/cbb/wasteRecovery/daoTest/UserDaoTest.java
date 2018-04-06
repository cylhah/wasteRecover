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
        user.setOpenid("qwer");
        user.setAvater("dr");
        user.setState(1);
        int i=userDao.insertUser(user);
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

        User user=new User();
        user.setState(2);
        userDao.updateData(user);
    }

    @Test
    public void deleteUser() throws Exception{

        String openid="qw";


        int i=userDao.deleteUser(openid);
        System.out.println(i);
    }
}
