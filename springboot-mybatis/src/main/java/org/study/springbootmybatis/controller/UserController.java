package org.study.springbootmybatis.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.springbootmybatis.client.UserClient;
import org.study.springbootmybatis.model.po.UserInfoCom;
import org.study.springbootmybatis.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserClient userClient;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UserInfoCom getUserInfo(@PathVariable("id") Integer id){
        return userService.getUserInfo(id);
    }

    @RequestMapping(path = "/turn/{id}", method = RequestMethod.GET)
    public UserInfoCom getUserInfoByFeign(@PathVariable("id") Integer id) {
        System.out.println("hello");
        System.out.println(userClient.getClass().getName());
        return userClient.getUser(id);
    }


}
