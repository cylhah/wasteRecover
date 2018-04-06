package org.cbb.wasteRecovery.daoTest;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.ScrapDao;
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

        String typeName="可回收";
        String name="瓶子";
        double unitPrice=102;
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
    public void selectByTypeName() throws Exception{

        String typeName="可回收";
        int offset=0;
        int limit=1;
        List<Scrap> scrap=scrapDao.selectByTypeName(typeName,offset, limit);
        for(Scrap Scrap1:scrap)
        {
            System.out.println(Scrap1);
        }


    }
    //返回值为org.cbb.wasteRecovery.bean.Scrap@4bc222e


    @Test
    public void updateData() throws Exception{

        Scrap scrap=new Scrap();
        scrap.setName("塑料袋");
        scrap.setTypeName("不可回收");
        scrap.setUnitPrice(145.2);
        scrap.setId(1);
        int i= scrapDao.updateData(scrap);
        System.out.println(i);
    }
    //返回值为1

    @Test
    public void updateMonthVolume() throws Exception {

        int id=1;
        double monthVolume=50;
        int i=scrapDao.updateMonthVolume(id,monthVolume);
        System.out.println(i);

    }
    //返回值为1

    @Test
    public void updateTotalVolume() throws Exception {

        int id=1;
        double totalVolume=100;
        int i=scrapDao.updateTotalVolume(id,totalVolume);
        System.out.println(i);

    }
    //返回值为1

    @Test
    public void deleteScrap() throws Exception{




        int i=scrapDao.deleteScrap(2);
        System.out.println(i);
    }
    //返回值为1

}
