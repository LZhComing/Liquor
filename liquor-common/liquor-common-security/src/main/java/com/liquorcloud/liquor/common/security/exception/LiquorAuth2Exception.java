package com.liquorcloud.liquor.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liquorcloud.liquor.common.security.component.LiquorAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author lengleng
 * @date 2019/2/1
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = LiquorAuth2ExceptionSerializer.class)
public class LiquorAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public LiquorAuth2Exception(String msg) {
		super(msg);
	}

	public LiquorAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
