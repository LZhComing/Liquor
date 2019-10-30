package com.liquorcloud.liquor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Liquor授权服务器
 * @author zzc
 */
@SpringBootApplication
public class LiquorAuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiquorAuthServerApplication.class,args);
    }
}
