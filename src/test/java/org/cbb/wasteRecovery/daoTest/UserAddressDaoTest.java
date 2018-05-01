package org.cbb.wasteRecovery.daoTest;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.UserAddressDao;
import org.cbb.wasteRecovery.entity.GeoHash;
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
        /**
         *Preparing: insert into useraddress(uid,address,detail,community_id,geohash,position,phoneNumber,name)
         * values (?,?,?,?,?, point(?,?),?,?)
         *Parameters: 1001(String), 浙江省杭州市浙江科技学院小和山校区(String), 西和公寓707(String), 1(Integer), ypbf(String),
         *  89.11(Double), 91.25(Double), 137222222222(String), 汪宏斌(String)
         *Updates: 1
         */
        UserAddress userAddress=new UserAddress();
        userAddress.setUid("1001");
        userAddress.setAddress("浙江省杭州市浙江科技学院小和山校区");
        userAddress.setCommunity_id(1);
        userAddress.setLocationX(89.11);
        userAddress.setLocationY(91.25);
        userAddress.setGeohash(new GeoHash().encode(userAddress.getLocationX(),userAddress.getLocationY()));
        userAddress.setDetail("西和公寓707");
        userAddress.setPhoneNumber("137222222222");
        userAddress.setName("汪宏斌");
        int i=userAddressDao.insertAddress(userAddress);
        System.out.println(i);

    }

    @Test
    public void selectById() throws Exception{

       UserAddress userAddress= userAddressDao.selectById(2);
        System.out.println(userAddress);
    }


    @Test
    public void selectByUid() throws Exception{

        String uid="1001";
      List<UserAddress> userAddress= userAddressDao.selectByUid(uid);
        for(UserAddress userAddress1:userAddress)
        {
            System.out.println(userAddress1);
        }
    }

    @Test
    public void updateAddress() throws Exception{
        /**
         * Preparing: update useraddress set address = ? where id = ?
         * Parameters: 杭州(String), 2(Integer)
         * Updates: 1
         */

      UserAddress userAddress=new UserAddress();
        userAddress.setAddress("杭州");
        userAddress.setId(2);
        int i=userAddressDao.updateAddress(userAddress);
        System.out.println(i);
    }

    @Test
    public void deleteAddress() throws Exception{
        /**
         * Preparing: delete from useraddress where id=?
         * Parameters: 3(Integer)
         * Updates: 1
         */

        int i=userAddressDao.deleteAddress(3);
        System.out.println(i);


    }
}
