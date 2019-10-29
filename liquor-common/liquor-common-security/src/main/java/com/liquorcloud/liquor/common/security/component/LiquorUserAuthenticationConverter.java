
package com.liquorcloud.liquor.common.security.component;

import com.liquorcloud.liquor.common.core.constant.SecurityConstants;
import com.liquorcloud.liquor.common.security.service.LiquorUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户token转换
 * @author zzc
 * @date 2019-10-23
 * <p>
 * 根据checktoken 的结果转化用户信息
 */
public class LiquorUserAuthenticationConverter implements UserAuthenticationConverter {
	private static final String N_A = "N/A";

	/**
	 * 提取要在访问令牌中使用的用户的信息
	 *
	 * @param authentication 代表用户的身份验证
	 * @return 表示用户的唯一信息的键值映射
	 */
	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put(USERNAME, authentication.getName());
		if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
			response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
		}
		return response;
	}

	/**
	 * 从映射中提取身份验证。
	 *
	 * @param map 用户信息map
	 * @return 表示用户的身份验证，如果没有，则为null
	 */
	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		if (map.containsKey(USERNAME)) {
			Collection<? extends GrantedAuthority> authorities = getAuthorities(map);

			String username = (String) map.get(SecurityConstants.DETAILS_USERNAME);
			Integer id = (Integer) map.get(SecurityConstants.DETAILS_USER_ID);
			Integer deptId = (Integer) map.get(SecurityConstants.DETAILS_DEPT_ID);
			LiquorUser user = new LiquorUser(id, deptId, username, N_A, true
				, true, true, true, authorities);
			return new UsernamePasswordAuthenticationToken(user, N_A, authorities);
		}
		return null;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
		Object authorities = map.get(AUTHORITIES);
		if (authorities instanceof String) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
		}
		if (authorities instanceof Collection) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
				.collectionToCommaDelimitedString((Collection<?>) authorities));
		}
		throw new IllegalArgumentException("权限必须是字符串或集合!");
	}
}
