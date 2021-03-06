package com.liquorcloud.liquor.common.core.feign.factory;

import com.liquorcloud.liquor.common.core.feign.fallback.RemoteUserServiceFallbackImpl;
import com.liquorcloud.liquor.common.core.feign.RemoteUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zzc
 */
@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {

	@Override
	public RemoteUserService create(Throwable throwable) {
		RemoteUserServiceFallbackImpl remoteUserServiceFallback = new RemoteUserServiceFallbackImpl();
		remoteUserServiceFallback.setCause(throwable);
		return remoteUserServiceFallback;
	}
}
