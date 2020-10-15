package com.liquorcloud.liquor.common.security.service;

import com.liquorcloud.liquor.common.core.constant.SecurityConstants;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * 获取客户端配置信息
 * @author zzc
 * @date 2019/10/23
 * see JdbcClientDetailsService
 */
@Slf4j
public class LiquorClientDetailsService extends JdbcClientDetailsService {

	public LiquorClientDetailsService(DataSource dataSource) {
		super(dataSource);
	}

	/**
	 * 重写原生方法支持redis缓存
	 * 当返回结果不为空时，调用父类方法存储token
	 */
	@Override
	@SneakyThrows
	@Cacheable(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#clientId", unless = "#result == null")
	public ClientDetails loadClientByClientId(String clientId) {
		long start = System.currentTimeMillis();
		ClientDetails clientDetails = super.loadClientByClientId(clientId);
		log.info("从缓存获取客户端信息耗时：{}",System.currentTimeMillis()-start);
		return clientDetails;
	}
}
