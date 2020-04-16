package com.pytap.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Ecin520
 * @date 2020/4/15 21:31
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
