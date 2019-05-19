package com.hug.it.ShibaInu.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
 
/**  
 * 实现增删改查的基本sql功能
 * 特别注意，该接口不能被扫描到，否则会出错
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}