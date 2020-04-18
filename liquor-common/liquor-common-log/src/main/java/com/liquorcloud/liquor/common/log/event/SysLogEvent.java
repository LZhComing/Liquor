package com.liquorcloud.liquor.common.log.event;

import com.liquorcloud.liquor.common.model.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author zzc
 * 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}
}
