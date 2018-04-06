package org.cbb.wasteRecovery.daoTest;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.UserAddressDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserAddressDaoTest {

    @Resource
    private UserAddressDao userAddressDao;


    @Test
    public void insertAddress() throws Exception{


        String uid="qw";

        String address="erdfa";
        int community_id=1;
        String geohash="asd";
        String detail="cvb";
        double locationX=2.34;
        double locationY=4.56;
        int i=userAddressDao.insertAddress(uid,address, detail, community_id, geohash, locationX, locationY);
        System.out.println(i);

    }
    //返回值为1

    @Test
    public void selectById() throws Exception{

       UserAddress userAddress= userAddressDao.selectById(1);
        System.out.println(userAddress);
    }
    //返回值为org.cbb.wasteRecovery.bean.UserAddress@31edaa7d


    @Test
    public void selectByUid() throws Exception{

        String uid="qw";
        int offset=1;
        int limit=1;
      List<UserAddress> userAddress= userAddressDao.selectByUid(uid,offset,limit);
        for(UserAddress userAddress1:userAddress)
        {
            System.out.println(userAddress1);
        }
    }
    //返回值为Disconnected from the target VM, address: '127.0.0.1:60010', transport: 'socket'

    @Test
    public void updateAddress() throws Exception{

      UserAddress userAddress=new UserAddress();
        userAddress.setAddress("杭州");
        userAddress.setId(2);
        int i=userAddressDao.updateAddress(userAddress);
        System.out.println(i);
    }
    //返回值为0

    @Test
    public void deleteAddress() throws Exception{


        int i=userAddressDao.deleteAddress(1);
        System.out.println(i);


    }
    //返回值为1
}
