package com.hug.it.ShibaInu.entity;

import com.hug.it.ShibaInu.annotations.MyNameStyle;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.Table;

@Data
@MyNameStyle
//@NameStyle
@Table(name = "TB_MEMBER")
public class Member extends BaseEntity {
    private String name;
    private Integer age;
}
