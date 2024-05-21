package org.study.springbootmybatis.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.study.springbootmybatis.model.po.UserInfoCom;

@FeignClient(name="aa", url="localhost:8080", path = "/api")
public interface UserClient {
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    UserInfoCom getUser(@PathVariable("id") Integer id);
}
