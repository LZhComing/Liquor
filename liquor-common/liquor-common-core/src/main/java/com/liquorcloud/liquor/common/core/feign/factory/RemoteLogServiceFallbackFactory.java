package com.liquorcloud.liquor.common.core.feign.factory;

import com.liquorcloud.liquor.common.core.feign.fallback.RemoteLogServiceFallbackImpl;
import com.liquorcloud.liquor.common.core.feign.RemoteLogService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zzc
 */
@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService> {

	@Override
	public RemoteLogService create(Throwable throwable) {
		RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
		remoteLogServiceFallback.setCause(throwable);
		return remoteLogServiceFallback;
	}
}
