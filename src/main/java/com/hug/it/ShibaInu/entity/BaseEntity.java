package com.hug.it.ShibaInu.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class BaseEntity {
    //AUTO主键由程序控制, 是默认选项 ,不设置就是这个
    //IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
    //SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
