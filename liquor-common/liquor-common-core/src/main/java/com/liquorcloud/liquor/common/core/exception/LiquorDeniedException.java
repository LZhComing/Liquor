package com.liquorcloud.liquor.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author zzc
 * 403 授权拒绝
 */
@NoArgsConstructor
public class LiquorDeniedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LiquorDeniedException(String message) {
		super(message);
	}

	public LiquorDeniedException(Throwable cause) {
		super(cause);
	}

	public LiquorDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public LiquorDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
