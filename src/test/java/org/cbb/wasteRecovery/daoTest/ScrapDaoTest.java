package org.cbb.wasteRecovery.daoTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.ScrapDao;
import org.cbb.wasteRecovery.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ScrapDaoTest {

    @Resource
    private ScrapDao scrapDao;


    @Test
    public void insertScrap() throws Exception {
        /**
         * Preparing: insert into scrap(typeName,name,unitPrice) values (?,?,?)
         * Parameters: 玻璃(String), 钢化玻璃(String), 11.1(Double)
         * Updates: 1
         */

        String typeName="玻璃";
        String name="钢化玻璃";
        double unitPrice=11.1;
        int i=scrapDao.insertScrap(typeName,name,unitPrice);
        System.out.println(i);

    }
    //返回值为1


    @Test
    public void selectByTid() throws Exception{

        Scrap scrap=scrapDao.selectByid(1);
        System.out.println(scrap);

    }
    //返回值为org.cbb.wasteRecovery.bean.Scrap@dc9876b

    @Test
    public void FilterScrapPage() throws Exception{

        Map constrains=new HashMap();
        constrains.put("typeName","玻璃");
        Page page=new Page(2);
        List<Scrap> scrap=scrapDao.FilterScrapPage(constrains,page);
        for(Scrap Scrap1:scrap)
        {
            System.out.println(Scrap1);
        }


    }


    @Test
    public void updateData() throws Exception{
        /**
         * Preparing: update scrap set typeName=?, name=?, unitPrice=? where id=?
         * Parameters: 塑料(String), 塑料袋(String), 0.2(Double), 5(Integer)
         * Updates: 1
         */

        Scrap scrap=new Scrap();
        scrap.setName("塑料袋");
        scrap.setTypeName("塑料");
        scrap.setUnitPrice(0.2);
        scrap.setId(5);
        int i= scrapDao.updateData(scrap);
        System.out.println(i);
    }


    @Test
    public void AddVolume() throws Exception {
        /**
         * Preparing: update scrap set monthVolume=monthVolume+?, totalVolume=totalVolume+? where id=?
         * Parameters: 50.0(Double), 50.0(Double), 4(Integer)
         * Updates: 1
         */

        int id=4;
        double volume=50;
        int i=scrapDao.AddVolume(id,volume);
        System.out.println(i);

    }



    @Test
    public void deleteScrap() throws Exception{
        /**
         * Preparing: delete from scrap where id=?
         * Parameters: 6(Integer)
         * Updates: 1
         */
        int i=scrapDao.deleteScrap(6);
        System.out.println(i);
    }


}
