package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.SUser;
import com.litbo.hospital.user.dao.UserDao;
import com.litbo.hospital.user.service.UserService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import com.litbo.hospital.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserDao userDao;

    @Override
    public SUser getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public Integer setUser(String userId) {

        SUser u =new SUser();
        u.setUserId(userId);
        u.setUserName(userId);
        u.setUserPwd(userId);
        //修改emp表中标记值   未写
        if(userDao.addUser(u)>0){
           return userDao.changeStatus(userId);
        }
        return -1;
    }

    @Override
    public Integer updatePwd(String userId, String userPwd) {

        return userDao.updatePwd(userId,userPwd);
    }

    @Override
    public UserVo getUserById(String userId) {

       return userDao.getUserByUserId(userId);
    }

    @Override
    public Integer delUser(String id) {
        if(userDao.getUserByUserId(id)==null){
            return 1;
        }
        if(userDao.delUser(id)>0){
            userDao.changeStatus0(id);
            userDao.delRole(id);
            return 1;
        }
       return 1/0;
    }

    @Override
    public LiveEmpVo getLiveUserById(String userId) {

        return  userDao.getLiveUserById(userId);

    }
}
