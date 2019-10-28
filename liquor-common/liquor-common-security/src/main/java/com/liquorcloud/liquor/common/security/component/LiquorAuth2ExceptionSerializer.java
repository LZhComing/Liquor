package com.liquorcloud.liquor.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.liquorcloud.liquor.common.core.constant.CommonConstants;
import com.liquorcloud.liquor.common.security.exception.LiquorAuth2Exception;
import lombok.SneakyThrows;

/**
 * @author lengleng
 * @date 2019/2/1
 * <p>
 * OAuth2 异常格式化
 */
public class LiquorAuth2ExceptionSerializer extends StdSerializer<LiquorAuth2Exception> {
	public LiquorAuth2ExceptionSerializer() {
		super(LiquorAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(LiquorAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
