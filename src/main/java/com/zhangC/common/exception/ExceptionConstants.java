package com.zhangC.common.exception;

public interface ExceptionConstants {
	String CODE_API_SUCCESS="1";
	String MSG_API_SUCCESS="操作成功!";

	String CODE_API_FAIL="2";
	String MSG_API_FAIL="权限校验失败，DGP返回数据为空";

	String CODE_API_ERROR="3";
	String MSG_API_ERROR="服务器内部错误";

	String CODE_API_NULLJWT="4";
	String MSG_API_NULLJWT="jwt参数为空";

}
