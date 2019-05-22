package com.hug.it.ShibaInu.controller;

import com.hug.it.ShibaInu.annotations.ActivityApiOperation;
import com.hug.it.ShibaInu.annotations.MyApiOperation;
import com.hug.it.ShibaInu.entity.User;
import com.hug.it.ShibaInu.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @GetMapping("/add/{name}/{age}")
    @ApiOperation(value = "新增用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataType = "integer"),
    })
    public User addUser(@PathVariable String name, @PathVariable int age) {
        log.info("新增用户,name:{}，age:{}", name,age);
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int i = userMapper.insertSelective(user);
        return user;
    }

    @GetMapping("/get/{id}")
    @MyApiOperation(value = "通过ID查询")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "integer", paramType = "path")
    public String findById(@PathVariable int id) {

        return "id查询成功";
    }

    @GetMapping("/find/{name}")
    @ActivityApiOperation(value = "活动接口")
    public List<User> findUser(@PathVariable String name) {
        List<User> userList = userMapper.findUserByName(name);

        return userList;
    }

    @GetMapping("/mini/getAll")
    @ApiOperation(value = "小程序，查询所有用户")
    public List<User> findById() {

        return userMapper.selectAll();
    }
}