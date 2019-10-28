package com.liquorcloud.liquor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zzc
 * @date 2018年06月21日
 * 服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class LiquorEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquorEurekaApplication.class, args);
    }

}
