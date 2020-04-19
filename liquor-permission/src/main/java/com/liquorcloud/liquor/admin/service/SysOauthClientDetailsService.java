package com.liquorcloud.liquor.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liquorcloud.liquor.common.model.entity.OauthClientDetails;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zzc
 */
public interface SysOauthClientDetailsService extends IService<OauthClientDetails> {
	/**
	 * 通过ID删除客户端
	 *
	 * @param id
	 * @return
	 */
	Boolean removeClientDetailsById(String id);

	/**
	 * 根据客户端信息
	 *
	 * @param oauthClientDetails
	 * @return
	 */
	Boolean updateClientDetailsById(OauthClientDetails oauthClientDetails);
}
