package com.liquorcloud.liquor;

import com.liquorcloud.liquor.common.security.annotation.EnableLiquorFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Liquor授权服务器
 * @author zzc
 */
@EnableLiquorFeignClients
@SpringBootApplication
public class LiquorAuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiquorAuthServerApplication.class,args);
    }
}
