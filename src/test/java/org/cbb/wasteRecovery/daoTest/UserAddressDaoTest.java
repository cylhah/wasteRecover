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
        UserAddress userAddress;
        userAddress = new UserAddress();
        userAddress.setAddress("浙江");
        userAddress.setFullADD("杭州");
        userAddress.setGeohash("asdf");
        userAddress.setUid(1);
        userAddressDao.insertAddress(userAddress);

    }

    @Test
    public void selectById() throws Exception{

        UserAddress userAddress= userAddressDao.selectById(1);
        System.out.println(userAddress);
    }

    @Test
    public void selectByUid() throws Exception{

        List<UserAddress> userAddress= userAddressDao.selectByUid(1);
        for(UserAddress userAddress1:userAddress)
        {
            System.out.println(userAddress1);
        }
    }
    @Test
    public void updateAddress() throws Exception{

        UserAddress userAddress=new UserAddress();
        userAddress.setAddress("杭州");
        userAddress.setId(2);
        userAddressDao.updateAddress(userAddress);
    }

    @Test
    public void deleteAddress() throws Exception{




        userAddressDao.deleteAddress(1);
    }
}
