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

    @Test
    public void insertUser() throws Exception{
        /**
         * Preparing: insert ignore into user(openid) values (?)
         * Parameters: 1001(String)
         * Updates: 1
         * 1
         */
        String openId="1001";
        int i=userDao.insertUser(openId);
        System.out.println(i);
    }

    @Test
    public void selectById() throws Exception{
        /**
         * Preparing: select u.state,u.avater,u.openid,
         * b.id,b.account,b.bank_code,b.username,
         * a.id,a.uid,a.address,a.detail,a.community_id,a.geohash,a.position
         * from (user u LEFT JOIN useraddress a ON u.openid=a.id) LEFT JOIN bankaccount b ON u.openid=b.uid where u.openid=?
         * Parameters: 1000(String)
         * Total: 1
         * User{openid='1000', avater='null', state=1, addressList=[], accountList=[]}
         */
        String openid="1000";
        User user=userDao.selectById(openid);
        System.out.println(user);
    }

    @Test
    public void banUser() throws Exception{
        /**
         *  Preparing: update user set state=0 where openid=?
         * Parameters: ypbp(String)
         *  Updates: 1
         */
        String openid="ypbp";
        int i=userDao.banUser(openid);
        System.out.println(i);
    }





    @Test
    public void updateData() throws Exception{

        /**
         * Preparing: update user set avater=? where openid=?
         * Parameters: user/document/test.jpg(String), 1001(String)
         *  Updates: 1
         */
        String openId="1001";
        String avater="user/document/test.jpg";
       int i= userDao.updateData(openId,avater);
        System.out.println(i);
    }

    @Test
    public void deleteUser() throws Exception{
        /**
         * Preparing: delete from user where openid=?
         * Parameters: ypbp(String)
         * Updates: 1
         */

        String openid="ypbp";


        int i=userDao.deleteUser(openid);
        System.out.println(i);
    }
}
