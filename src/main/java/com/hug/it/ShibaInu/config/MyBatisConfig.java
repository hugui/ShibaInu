package com.hug.it.ShibaInu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.persistence.Column;
import java.util.Properties;

/**
 * tk.mybatis配置信息
 */
@Configuration
public class MyBatisConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.hug.it.ShibaInu.mapper");
        Properties properties = new Properties();
//        properties.setProperty("mappers", "com.hug.it.ShibaInu.mapper");
//        properties.setProperty("notEmpty", "false");
//        properties.setProperty("IDENTITY", "MYSQL");
//        properties.setProperty("style", "normal");
        properties.setProperty("resolveClass", "com.hug.it.ShibaInu.common.MyEntityResolve");

        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
