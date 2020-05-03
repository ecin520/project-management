package com.pytap.project.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Ecin520
 * @date 2020/3/26 23:18
 */
@SpringBootApplication(scanBasePackages = {"com.pytap.project"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WebApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
