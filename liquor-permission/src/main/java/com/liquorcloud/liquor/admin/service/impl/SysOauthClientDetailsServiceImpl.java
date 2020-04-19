package com.liquorcloud.liquor.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liquorcloud.liquor.common.model.entity.OauthClientDetails;
import com.liquorcloud.liquor.admin.mapper.SysOauthClientDetailsMapper;
import com.liquorcloud.liquor.admin.service.SysOauthClientDetailsService;
import com.liquorcloud.liquor.common.core.constant.SecurityConstants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzc
 */
@Service
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, OauthClientDetails> implements SysOauthClientDetailsService {

	/**
	 * 通过ID删除客户端
	 *
	 * @param id
	 * @return
	 */
	@Override
	@CacheEvict(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#id")
	public Boolean removeClientDetailsById(String id) {
		return this.removeById(id);
	}

	/**
	 * 根据客户端信息
	 *
	 * @param clientDetails
	 * @return
	 */
	@Override
	@CacheEvict(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#clientDetails.clientId")
	public Boolean updateClientDetailsById(OauthClientDetails clientDetails) {
		return this.updateById(clientDetails);
	}
}
