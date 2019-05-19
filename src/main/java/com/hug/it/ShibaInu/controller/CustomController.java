package com.hug.it.ShibaInu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/custom")
@Api(tags = "客户管理")
public class CustomController {

    @GetMapping("/query/{id}")
    @ApiOperation("通过ID查询")
    @ApiImplicitParam(name = "id", value = "客户ID", required = true, dataType = "integer", paramType = "path")
    public String findById(@PathVariable int id) {

        return "id查询客户成功";
    }
}