package com.zhangC.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndexDaoMapping {


	/**
	 * 获取设备信息
	 *
	 * @return
	 */
	List<Map<String,String>> queryMobileInfo(@Param("mobileId") String mobileId);


}