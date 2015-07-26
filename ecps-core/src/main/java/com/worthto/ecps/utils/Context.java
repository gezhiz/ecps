package com.worthto.ecps.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

/**
 * 提供一个读取ecps.properties配置文件属性的类
 * 
 * @author Administrator
 * 
 */
@Component
public class Context {
	private static Map<String, String> map = new HashMap<String, String>();
	private static Context instance = new Context();
	// 读取ecps.properties
	static {
		ResourceBundle rb = ResourceBundle.getBundle("ecps");
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = rb.getString(key);
			map.put(key, value);
		}
	}

	private Context() {
	}

	public Context getInstance() {
		return instance;
	}

	// 获取一个值
	public static String getString(String key) {
		return map.get(key);
	}

	// 获取一个值
	public static Integer getInt(String key) {
		return Integer.parseInt(map.get(key));
	}

}
