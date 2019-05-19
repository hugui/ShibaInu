package com.hug.it.ShibaInu.mapper;

import com.hug.it.ShibaInu.common.MyMapper;
import com.hug.it.ShibaInu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends MyMapper<User> {

    @Select("select CNAME from TB_USER where IID = #{userId}")
    String getUserNameById( long userId);
}
