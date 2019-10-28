package com.liquorcloud.liquor.admin;


import com.liquorcloud.liquor.common.security.annotation.EnableLiquorFeignClients;
import com.liquorcloud.liquor.common.security.annotation.EnableLiquorResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author lengleng
 * @date 2018年06月21日
 * 用户统一管理系统
 */
@EnableLiquorResourceServer
@EnableLiquorFeignClients
@SpringCloudApplication
public class LiquorPermissionApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiquorPermissionApplication.class, args);
	}

}
