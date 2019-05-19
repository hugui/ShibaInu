package com.hug.it.ShibaInu.mapper;

import com.hug.it.ShibaInu.common.MyMapper;
import com.hug.it.ShibaInu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper<User> {

    @Select("select CNAME from TB_USER where IID = #{userId}")
    String getUserNameById(long userId);

    @Select("select * from TB_USER where CNAME = #{name}")
    List<User> findUserByName(String name);
}
