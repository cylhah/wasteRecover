package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.*;
import org.cbb.wasteRecovery.entity.Page;
import org.cbb.wasteRecovery.enums.OrderStateEnum;
import org.cbb.wasteRecovery.enums.UserStateEnum;
import org.cbb.wasteRecovery.service.SelectService;

import java.util.List;

public class SelectServiceImp implements SelectService {
    public List<Collector> selectCollByName(String realName, Page page) {
        return null;
    }

    public Collector selectCollById(int id) {
        return null;
    }

    public Collector selectCollByPhoneNum(String phoneNumber) {
        return null;
    }

    public Collector selectCollByIdCardNum(String idCardNum) {
        return null;
    }

    public List<Orderform> selectOrders(OrderStateEnum orderStateEnum, Page page) {
        return null;
    }

    public List<Orderform> selectOrders(Collector collector, OrderStateEnum orderStateEnum, Page page) {
        return null;
    }

    public List<Orderform> selectOrders(User user, OrderStateEnum orderStateEnum, Page page) {
        return null;
    }

    public List<Orderform> selectOrders(Community community, OrderStateEnum orderStateEnum, Page page) {
        return null;
    }

    public Consultant selectConsultant(int id) {
        return null;
    }

    public List<Consultant> selectConsultantByStaId(int staid, Page page) {
        return null;
    }

    public List<Scrap> selectScrapByTypeName(String typeName, Page page) {
        return null;
    }

    public List<Scrap> selectScrapByName(String name, Page page) {
        return null;
    }

    public Station selectStation(int id) {
        return null;
    }

    public List<Station> selectStationByAddress(String address) {
        return null;
    }

    public List<Station> selectStationByName(String name) {
        return null;
    }

    public User selectUserById(String openid) {
        return null;
    }

    public List<User> selectUser(UserStateEnum userStateEnum, Page page) {
        return null;
    }
}
