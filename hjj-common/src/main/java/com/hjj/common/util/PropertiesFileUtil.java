package com.hjj.common.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PropertiesFileUtil {
	private static Map<String, PropertiesFileUtil> configMap = new HashMap<String, PropertiesFileUtil>();
	private Date loadTime = null;
	private ResourceBundle resourceBundle = null;
	private static final String NAME = "config";
	private static final int TIME_OUT = 60 * 1000;

	private PropertiesFileUtil(String name) {
		this.loadTime = new Date();
		this.resourceBundle = ResourceBundle.getBundle(name);
	}
	
	public static synchronized PropertiesFileUtil getInstance() {
		return getInstance(NAME);
	}

	public static synchronized PropertiesFileUtil getInstance(String name) {
		PropertiesFileUtil config = configMap.get(name);
		if (config == null) {
			config = new PropertiesFileUtil(name);
			configMap.put(name, config);
		}
		if ((System.currentTimeMillis() - config.getLoadTime().getTime()) > TIME_OUT) {
			config = new PropertiesFileUtil(name);
			configMap.put(name, config);
		}
		return config;
	}
	
	/**
	 * 根据key读取value
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return resourceBundle.getString(key);
	}
	
	/**
	 * 根据key读取value（整型）
	 * @param key
	 * @return
	 */
	public Integer getInt(String key) {
		String value = resourceBundle.getString(key);
		return Integer.valueOf(value);
	}
	
	public Date getLoadTime() {
		return loadTime;
	}

}
