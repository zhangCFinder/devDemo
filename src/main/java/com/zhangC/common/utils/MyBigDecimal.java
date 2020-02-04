package com.zhangC.common.utils;

import java.math.BigDecimal;

/**
 * Created by zhangc on 2018-10-23.
 */
public class MyBigDecimal {
	public static BigDecimal getBigDecimal(String val) {
		BigDecimal bigDecimal;
		if (StringUtil.isNotNull(val)) {
			Boolean strResult = val.matches("-?[0-9]+.*[0-9]*");
			if (strResult) {
				bigDecimal = new BigDecimal(val);
			}else {
				bigDecimal = new BigDecimal(0);
			}
		} else {
			bigDecimal = new BigDecimal(0);
		}
		return bigDecimal;
	}
}
