package com.liquorcloud.liquor.common.security.component;

import lombok.SneakyThrows;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * 资源服务器自动配置
 * @author zzc
 * @date 2019/10/24
 */
@ComponentScan("com.liquorcloud.liquor.common.security")
public class LiquorResourceServerAutoConfiguration {
	@Bean
	@Primary
	@LoadBalanced
	public RestTemplate RestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			@SneakyThrows
			public void handleError(ClientHttpResponse response) {
				if (response.getRawStatusCode() != HttpStatus.BAD_REQUEST.value()) {
					super.handleError(response);
				}
			}
		});
		return restTemplate;
	}
}
