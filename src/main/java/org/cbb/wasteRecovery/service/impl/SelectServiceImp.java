package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.*;
import org.cbb.wasteRecovery.dao.CollectorDao;
import org.cbb.wasteRecovery.dao.OrderformDao;
import org.cbb.wasteRecovery.dao.ScrapDao;
import org.cbb.wasteRecovery.dao.UserAddressDao;
import org.cbb.wasteRecovery.entity.GeoHash;
import org.cbb.wasteRecovery.entity.NeighborOrders;
import org.cbb.wasteRecovery.entity.Page;
import org.cbb.wasteRecovery.enums.filter.CollectorFilterEnum;
import org.cbb.wasteRecovery.enums.filter.FilterEnum;
import org.cbb.wasteRecovery.enums.filter.OrderFilterEnum;
import org.cbb.wasteRecovery.enums.filter.ScrapFilterEnum;
import org.cbb.wasteRecovery.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectServiceImp implements SelectService {

    @Autowired
    private OrderformDao orderformDao;

    @Autowired
    private UserAddressDao userAddressDao;

    @Autowired
    private CollectorDao collectorDao;

    @Autowired
    private ScrapDao scrapDao;

    private void setConstrains(FilterEnum filterEnum,Map constrains,Object object){
        try {
            Field field=object.getClass().getField(filterEnum.getField());
            field.setAccessible(true);
            if (field.get(object)!=null)
                constrains.put(filterEnum.getColumn(),field.get(object));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return;
    }

    public NeighborOrders selectOrdersByPos(UserAddress userAddress) {
        if(userAddress==null)
            return null;
        String geoHash=new GeoHash().encode(userAddress.getLocationX(),userAddress.getLocationY());
        List<Orderform> orderforms=orderformDao.selectByPos(userAddress.getUid(),geoHash,
                userAddress.getLocationX(),userAddress.getLocationY(),5000);
        return new NeighborOrders(orderforms);
    }

    public List<Orderform> selectOrdersByUid(String openid, Page page) {
        if(openid==null||openid.equals("")) return null;
        Map constrains=new HashMap();
        constrains.put(OrderFilterEnum.USER.getColumn(),openid);
        return orderformDao.filterOrderPage(constrains,page);
    }

    public List<UserAddress> selectAddressByUid(String openid) {
        if(openid==null||openid.equals(""))
            return null;
        return userAddressDao.selectByUid(openid);
    }

    public List<Orderform> FilterOrders(Orderform orderform, Page page) {
        if(orderform==null||page==null)
            return null;
        Map constrains=new HashMap();
        for (OrderFilterEnum filter:OrderFilterEnum.values()){
            setConstrains(filter,constrains,orderform);
        }
        return orderformDao.filterOrderPage(constrains,page);
    }

    public Orderform selectOrderByOid(String oid) {
        if(oid==null||oid.equals(""))
            return null;
        return orderformDao.selectById(Long.parseLong(oid));
    }

    public Collector selectCollectorByCid(String cid) {
        if(cid==null||cid.equals(""))
            return null;
        return collectorDao.selectById(Integer.parseInt(cid));
    }

    public List<Collector> FilterCollector(Collector collector, Page page) {
        Map constrains=new HashMap();
        for(CollectorFilterEnum filterEnum:CollectorFilterEnum.values()){
            setConstrains(filterEnum,constrains,collector);
        }
        return collectorDao.filterCollPage(constrains,page);
    }

    public List<Scrap> FilterScraps(Scrap scrap, Page page) {
        Map constrains=new HashMap();
        for(ScrapFilterEnum filterEnum:ScrapFilterEnum.values()){
            setConstrains(filterEnum,constrains,scrap);
        }
        return scrapDao.FilterScrapPage(constrains,page);
    }

}
