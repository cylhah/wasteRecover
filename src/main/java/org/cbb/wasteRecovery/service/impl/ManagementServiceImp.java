package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.service.ManagementService;

public class ManagementServiceImp implements ManagementService {
    public boolean banCollector(int id) {
        return false;
    }

    public boolean recoverCollector(int id) {
        return false;
    }

    public boolean banUser(String openId) {
        return false;
    }

    public boolean recoverUser(String openId) {
        return false;
    }

    public boolean addCommunity(Community community) {
        return false;
    }

    public boolean distributeCommunity(Community community) {
        return false;
    }

    public boolean changeCommunityAddress(Community community) {
        return false;
    }

    public boolean deleteCommunity(int id) {
        return false;
    }

    public boolean deleteCollector(int id) {
        return false;
    }

    public boolean deleteConsultant(int id) {
        return false;
    }
}
