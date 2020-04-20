package com.liquorcloud.liquor.common.security.service;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.liquorcloud.liquor.common.core.constant.CommonConstants;
import com.liquorcloud.liquor.common.core.constant.SecurityConstants;
import com.liquorcloud.liquor.common.core.feign.RemoteUserService;
import com.liquorcloud.liquor.common.core.util.R;
import com.liquorcloud.liquor.common.model.dto.UserInfo;
import com.liquorcloud.liquor.common.model.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户详细信息
 *
 * @author zzc
 */
@Slf4j
@Service
@AllArgsConstructor
public class LiquorUserDetailsServiceImpl implements UserDetailsService  {
	private final RemoteUserService remoteUserService;
	private final CacheManager cacheManager;

	/**
	 * 用户密码登录
	 *
	 * @param username 用户名
	 * @return UserDetails
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		long start = System.currentTimeMillis();
		Cache cache = cacheManager.getCache("user_details");
		if (cache != null && cache.get(username) != null) {
			log.info("从缓存获取用户信息耗时：{}",System.currentTimeMillis()-start);
			return (LiquorUser) Objects.requireNonNull(cache.get(username)).get();
		}

		R<UserInfo> result = remoteUserService.info(username, SecurityConstants.FROM_IN);
		UserDetails userDetails = getUserDetails(result);
		assert cache != null;
		cache.put(username, userDetails);
		return userDetails;
	}

	/**
	 * 构建userdetails
	 *
	 * @param result 用户信息
	 * @return UserDetails
	 */
	private UserDetails getUserDetails(R<UserInfo> result) {
		if (result == null || result.getData() == null) {
			throw new UsernameNotFoundException("用户不存在");
		}

		UserInfo info = result.getData();
		Set<String> dbAuthsSet = new HashSet<>();
		if (ArrayUtil.isNotEmpty(info.getRoles())) {
			// 获取角色
			Arrays.stream(info.getRoles()).forEach(role -> dbAuthsSet.add(SecurityConstants.ROLE + role));
			// 获取资源
			dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));

		}
		Collection<? extends GrantedAuthority> authorities
			= AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));
		SysUser user = info.getSysUser();

		// 构造security用户，这里的密码指定了加密方式，Security5新功能
		return new LiquorUser(user.getUserId(), user.getDeptId(), user.getUsername(), user.getPassword(),
			StrUtil.equals(user.getLockFlag(), CommonConstants.STATUS_NORMAL), true, true, true, authorities);
	}
}
