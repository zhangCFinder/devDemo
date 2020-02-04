package com.zhangC.common.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件工具类
 *
 * @author jiquanwei
 */
public class PropertiesUtil {

	//属性值

	private static Properties properties;

	// 导出excel数据条数
	private static int pageSize;


	static {
		properties = new Properties();
		InputStream inStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("conf/config.properties");
		try {
			properties.load(inStream);
			pageSize = Integer.valueOf(properties.getProperty("pageSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static Properties getProperties() {
		return properties;
	}


	public static void setProperties(Properties properties) {
		PropertiesUtil.properties = properties;
	}


	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		PropertiesUtil.pageSize = pageSize;
	}

}
