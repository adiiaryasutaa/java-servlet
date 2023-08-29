package ceceply.servlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;


public class JsonUtil {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		return OBJECT_MAPPER;
	}
}
