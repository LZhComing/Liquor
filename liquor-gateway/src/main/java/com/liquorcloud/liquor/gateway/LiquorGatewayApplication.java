package com.liquorcloud.liquor.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 服务网关
 * @author zzc
 */
@SpringCloudApplication
public class LiquorGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquorGatewayApplication.class, args);
    }

}
