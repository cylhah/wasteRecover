package org.cbb.wasteRecovery.entity;

import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.dao.CommunityDao;

import java.util.List;

public class MatchCommunity {
    //二分枚举前缀长度，匹配前缀，存在前缀重复bug，临时算法，不推荐正式运行使用
    public static Community FindCommunity(UserAddress userAddress, CommunityDao communityDao){
        if(userAddress==null||userAddress.getAddress()==null)
            return null;
        String uAddress=userAddress.getAddress();
        Community target = null;
        int left=0,right=uAddress.length()-1;
        int mid=(left+right)/2;
        while(left<=right){
            String temp=uAddress.substring(0,mid+1);
            List<Community> communityList=communityDao.selectByAddress(temp);
            if(communityList.size()!=0){
                left=mid+1;
                target=communityList.get(0);
            }
            else {
                right=mid-1;
            }
            mid=(left+right)/2;
        }
        if (right<0) return null;
        char c=uAddress.charAt(right);
        if(c=='国'||c=='省'||c=='市'||(c=='区'&&uAddress.charAt(right-1)!='小'))
            return null;
        return target;
    }

}
