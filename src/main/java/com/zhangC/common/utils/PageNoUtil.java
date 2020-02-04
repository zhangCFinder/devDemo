package com.zhangC.common.utils;

/**
 * Created by zhangc on 2018-10-11.
 */
public class PageNoUtil {
	//获取pageNo的起始位置
	public static int getStartPoint(Integer currentPage,Integer pageSize) {
		if (currentPage == null || currentPage <= 0) currentPage = 1;
		int startPoint = (currentPage - 1) * pageSize;
		return startPoint;
	}
}
