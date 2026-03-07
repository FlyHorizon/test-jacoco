package com.study.springbootmybatis.client;

import com.study.springbootmybatis.model.po.UserInfoCom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="aa", url="localhost:8080", path = "/api")
public interface UserClient {
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    UserInfoCom getUser(@PathVariable("id") Integer id);
}
