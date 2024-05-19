package org.study.springbootmybatis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.study.springbootmybatis.model.dao.UserInfoMapper;
import org.study.springbootmybatis.model.dao.UserMapper;
import org.study.springbootmybatis.model.po.UserInfoCom;
import org.study.springbootmybatis.model.pojo.User;
import org.study.springbootmybatis.model.pojo.UserInfo;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Wrapper;

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
