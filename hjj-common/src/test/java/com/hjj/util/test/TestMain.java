package com.hjj.util.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hjj.common.util.PropertiesFileUtil;

public class TestMain {
//	private static final Logger logger = LoggerFactory.getLogger(TestMain.class);
	@Test
	public void testPropertiesFileUtil() {
		
		String value = PropertiesFileUtil.getInstance().get("app.name");
//		logger.info(value);
		System.out.println(value);
	}
}
