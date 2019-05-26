package com.hug.it.ShibaInu.service.impl;

import com.hug.it.ShibaInu.mapper.UserMapper;
import com.hug.it.ShibaInu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
}
