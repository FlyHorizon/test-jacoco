package com.study.springbootmybatis.service;

import org.springframework.stereotype.Service;
import com.study.springbootmybatis.model.dao.UserInfoMapper;
import com.study.springbootmybatis.model.dao.UserMapper;
import com.study.springbootmybatis.model.po.UserInfoCom;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserInfoMapper userInfoMapper;


    public UserInfoCom getUserInfo(Integer id){
        System.out.println(userInfoMapper.getClass().getName());
        UserInfoCom userInfoCom = userInfoMapper.selectByUserid(id);
        


//        User user = userMapper.selectByPrimaryKey(id);
//        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
//        UserInfoCom userInfoCom = new UserInfoCom();
//        userInfoCom.setUserId(id);
//        userInfoCom.setUserName(user.getUsrName());
//        userInfoCom.setUserInfo(userInfo);
        return userInfoCom;

    }

}
