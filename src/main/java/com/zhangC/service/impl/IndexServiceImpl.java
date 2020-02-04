package com.zhangC.service.impl;

import com.zhangC.dao.mapper.IndexDaoMapping;
import com.zhangC.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class IndexServiceImpl implements IndexService {

	@Autowired
	IndexDaoMapping indexDaoMappingMapper;


	@Override
	public List<Map<String, String>> getDataIdInfo(String mobileId) {
		return indexDaoMappingMapper.queryMobileInfo(mobileId);
	}

	@Override
	public void testListener() {
		System.out.println("这是Spring加载的实现");
	}

}
