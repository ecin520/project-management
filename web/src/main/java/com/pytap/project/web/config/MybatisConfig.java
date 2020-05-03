package com.pytap.project.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Ecin520
 * @date 2020/4/27 22:49
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.pytap.project.dao", "com.pytap.project.web.dao"})
public class MybatisConfig {
}
