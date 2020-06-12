package com.ldd.xiaoxiya.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiaoxiya
 * @date 2020/6/12 21:10
 * @describe MyBatis配置类
 * 扫描mybatis的xml文件和生成的dao,或者直接在springboot启动类上加扫描
 * mapperscan注解扫描生成的接口路径
 * SpringBootApplication注解包含了ComonentScan注解，默认扫描和启动类同级的目录以及下面的子目录
 * 添加ComponentScan注解扫描指定目录以及子目录，可解决多模块下springboot启动类无法加载其他模块bean的问题
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.ldd.mapper","com.ldd.dao"})
public class MyBatisConfig {
}
