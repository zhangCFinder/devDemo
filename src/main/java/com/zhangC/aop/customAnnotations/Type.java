package com.zhangC.aop.customAnnotations;

/**
 * Created by zhangc on 2019/9/24.
 */
public enum  Type {
	/**
	 * 操作类型
	 */
	WARNING("警告", "因被其他玩家举报，警告玩家");

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 执行操作
	 */
	private String operation;

	Type(String type, String operation) {
		this.type = type;
		this.operation = operation;
	}

	public String getType() { return type; }

	public String getOperation() { return operation; }
}
