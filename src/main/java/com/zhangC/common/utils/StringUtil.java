package com.zhangC.common.utils;

/**
 * Created by zhangc on 2017/8/18.
 */

public class StringUtil  {

    public static boolean isEmpty(String string) {
        return string == null ? true : string.trim().length() == 0;
    }

    public static boolean isNotNull(Object obj) {
        if (obj != null && !"null".equals(obj.toString())) {
            return !isEmpty(obj.toString());
        } else {
            return false;
        }
    }


}
