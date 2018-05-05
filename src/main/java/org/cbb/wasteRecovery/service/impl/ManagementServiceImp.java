package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.dao.*;
import org.cbb.wasteRecovery.util.GeoHash;
import org.cbb.wasteRecovery.util.MatchCommunity;
import org.cbb.wasteRecovery.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagementServiceImp implements ManagementService {

    @Autowired
    UserAddressDao userAddressDao;

    @Autowired
    CommunityDao communityDao;

    @Autowired
    CollectorDao collectorDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ConsultantDao consultantDao;

    public boolean addUserAddress(UserAddress userAddress) {
        if (userAddress==null) return false;
        Community community=MatchCommunity.FindCommunity(userAddress,communityDao);
        userAddress.setCommunity_id(community.getId());
        userAddress.setGeohash(new GeoHash().encode(userAddress.getLocationX(),userAddress.getLocationY()));
        userAddressDao.insertAddress(userAddress);
        return true;
    }

    public boolean deleteUserAddress(String uaid) {
        if(uaid==null||uaid.equals(""))
            return false;
        if(userAddressDao.deleteAddress(Integer.parseInt(uaid))<1)
            return false;
        return true;
    }

    public boolean addCommunity(Community community) {
        if(community==null|| communityDao.insertCommunity(community.getAddress(),community.getName())<1)
            return false;

        return true;
    }

    public boolean updateCommunity(Community community) {
        if(community==null) return false;
        int len=communityDao.updateData(community.getId(),community.getName(),community.getAddress());
        return len>0?true:false;
    }

    public boolean deleteCommunity(String id) {
        if(id==null||id.equals(""))
            return false;
        int len=communityDao.deleteCommunity(Integer.parseInt(id));
        return len>0?true:false;
    }

    public boolean deleteCollector(String id) {
        if(id==null||id.equals(""))
            return false;
        int len=communityDao.deleteCommunity(Integer.parseInt(id));
        return len>0?true:false;
    }

    public boolean deleteConsultant(String username) {
        if(username.equals("")|username==null)
            return false;
        int len=consultantDao.deleteConsultant(username);
        return len>0?true:false;
    }

    public boolean banCollector(String id) {
        return false;
    }

    public boolean recoverCollector(String id) {
        return false;
    }

    public boolean banUser(String openId) {
        return false;
    }

    public boolean recoverUser(String openId) {
        return false;
    }
}
