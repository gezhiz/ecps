package com.worthto.ecps.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class EcpsUtils {
	/**
	 * 读取配置文件
	 * @param key
	 * @return
	 */
	public static String readProp(String key){
		Properties properties = new Properties();
		InputStream in = EcpsUtils.class.getClassLoader().getResourceAsStream("ecps.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
