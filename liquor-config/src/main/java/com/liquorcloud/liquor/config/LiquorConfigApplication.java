package com.liquorcloud.liquor.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zzc
 * @date 2019/10/23
 * 配置中心
 */
@EnableConfigServer
@SpringCloudApplication
public class LiquorConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquorConfigApplication.class, args);
	}
}
