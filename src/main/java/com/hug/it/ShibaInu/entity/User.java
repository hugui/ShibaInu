package com.hug.it.ShibaInu.entity;

import com.hug.it.ShibaInu.annotations.MyNameStyle;
import lombok.Data;

import javax.persistence.Table;

@Data
@MyNameStyle
@Table(name = "TB_USER")
public class User extends BaseEntity {
    private String name;
    private Integer age;
}
