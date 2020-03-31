package com.pytap.project;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 系统管理后台
 * @author Ecin520
 * @date 2020/3/26 21:14
 */
@SpringBootApplication
@EnableTransactionManagement
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
