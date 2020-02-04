package com.zhangC.db;

import org.springframework.stereotype.Repository;

@Repository
public class SystemVersionDao {

	/**
	 * 获取数据源
	 * 
	 * @return
	 */
	public String getSwitchDataSource() {
		String db = "10.10.1.17";
//		try {
//			String dbVal = redisClient.get(dbKeyInRedis);
//			if(StringUtils.isNotBlank(dbVal)){
//				db = dbVal.split("\\|")[0];
//			}
//		} catch (Exception e) {
//			logger.error(ExceptionUtils.getFullStackTrace(e));
//		}
		System.out.println("切换数据源为----------" + db);
		return db;
	}




}
