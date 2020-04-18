package com.liquorcloud.liquor.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liquorcloud.liquor.common.security.component.LiquorAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author zzc
 */
@JsonSerialize(using = LiquorAuth2ExceptionSerializer.class)
public class MethodNotAllowed extends LiquorAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
