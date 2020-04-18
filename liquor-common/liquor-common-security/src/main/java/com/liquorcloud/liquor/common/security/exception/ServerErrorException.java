package com.liquorcloud.liquor.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liquorcloud.liquor.common.security.component.LiquorAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author zzc
 */
@JsonSerialize(using = LiquorAuth2ExceptionSerializer.class)
public class ServerErrorException extends LiquorAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
