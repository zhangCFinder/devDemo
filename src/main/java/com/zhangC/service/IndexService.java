package com.zhangC.service;

import java.util.List;
import java.util.Map;

public interface IndexService {
    /**
     * 获取更新时间
     * @return
     */
    List<Map<String, String>> getDataIdInfo(String mobileId);

    void testListener();
}
