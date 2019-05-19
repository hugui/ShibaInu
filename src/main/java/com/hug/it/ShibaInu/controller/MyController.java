package com.hug.it.ShibaInu.controller;

import com.hug.it.ShibaInu.annotations.MyApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/my")
@Api(tags = "我的模块")
@MyApi(name = "我的自定义模块",versions = "1.0.0")
public class MyController {

    @GetMapping("/query/{id}")
    @ApiOperation("通过ID查询")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "integer", paramType = "path")
    public String findById(@PathVariable int id) {

        return "id查询成功";
    }
}