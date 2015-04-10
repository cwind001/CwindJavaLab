package com.cwind.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class TestHashMapToJson {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper = new ObjectMapper();
		mapper.enableDefaultTyping();
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(
				DeserializationConfig.Feature.AUTO_DETECT_CREATORS, true);
		mapper.getSerializationConfig().enable(SerializationConfig.Feature.INDENT_OUTPUT);
		
		Map<String, String> mappings = new HashMap<String, String>();
		mappings.put("key1", "value1");
		mappings.put("key2", "value2");
		mappings.put("key3", "value3");
		mappings.put("key4", "value4");
		System.out.println(mapper.writeValueAsString(mappings));
	}
}
