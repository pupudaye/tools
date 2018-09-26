package org.pl.sports.tools.entity;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigFactory {

	public  List<Menu> loadMenu(String path) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		JavaType javaType =mapper.getTypeFactory().constructParametricType(List.class, Menu.class); 
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(path);
		List<Menu> menus=mapper.readValue(url,javaType);
		return menus;
	}
	
}
