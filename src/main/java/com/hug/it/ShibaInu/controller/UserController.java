package com.hug.it.ShibaInu.controller;

import com.hug.it.ShibaInu.annotations.MyApi;
import com.hug.it.ShibaInu.annotations.MyApiOperation;
import com.hug.it.ShibaInu.entity.User;
import com.hug.it.ShibaInu.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/query/{id}")
    @ApiOperation(value = "通过ID查询")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long", paramType = "path")
    public User findById(@PathVariable long id) {
        log.info("通过ID查询,id:{}",id);
        String name = userMapper.getUserNameById(id);
        List<User> userList = userMapper.selectAll();
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @GetMapping("/query2/{id}")
//    @ApiOperation()
    @MyApiOperation(value = "通过ID查询222", author = "hugui", since = "3.0.0")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "integer", paramType = "path")
    public String findById2(@PathVariable int id) {

        return "id查询成功";
    }
}