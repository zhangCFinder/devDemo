package com.zhangC.db;

public class DynamicDSContext {
	private static final ThreadLocal<String> dsKey = new ThreadLocal<>();

	public static String get() {
		return dsKey.get();
	}

	public static void set(String key) {
		dsKey.set(key);
	}

	public static void clear() {
		dsKey.remove();
	}




}
