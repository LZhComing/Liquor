package com.liquorcloud.liquor.auth;

import com.liquorcloud.liquor.common.security.annotation.EnableLiquorFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zzc
 * @date 2018年10月24日
 * 认证授权中心
 */
@SpringCloudApplication
@EnableLiquorFeignClients
@ComponentScan(basePackages = "com.liquorcloud.liquor.common.core.feign")
public class LiquorAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiquorAuthApplication.class, args);
    }
}
