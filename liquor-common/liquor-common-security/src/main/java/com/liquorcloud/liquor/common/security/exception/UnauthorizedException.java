package com.liquorcloud.liquor.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liquorcloud.liquor.common.security.component.LiquorAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author zzc
 */
@JsonSerialize(using = LiquorAuth2ExceptionSerializer.class)
public class UnauthorizedException extends LiquorAuth2Exception {

	public UnauthorizedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "unauthorized";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
