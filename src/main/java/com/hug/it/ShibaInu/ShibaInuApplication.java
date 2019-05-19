package com.hug.it.ShibaInu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hug.it.ShibaInu.mapper") //通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
public class ShibaInuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShibaInuApplication.class, args);
    }

}
