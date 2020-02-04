package com.zhangC.common.utils;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisClient {


	Logger logger = LoggerFactory.getLogger(RedisClient.class);


	private JedisPool jedisPool;


	public RedisClient(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public void destroy() {
		if (!jedisPool.isClosed())
			jedisPool.close();
	}


	public String get(String key) {
		return get(key, null);
	}

	public byte[] get(final byte[] key) {
		Jedis jedis = null;
		byte[] result = null;
		try {
			jedis = getJedis();
			result = jedis.get(key);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	public String get(final String key, final Integer expireTime) {

		Jedis jedis = null;
		String result = "";
		try {
			jedis = getJedis();
			result = jedis.get(key);
			if (expireTime != null) {
				jedis.expire(key, expireTime);
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}


	public String set(final String key, final String val) {

		Jedis jedis = null;
		String result = "";
		try {
			jedis = getJedis();
			result = jedis.set(key, val);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}


	public Long expire(String key, int seconds) throws Exception {

		Jedis jedis = null;
		Long result = null;
		try {
			jedis = getJedis();
			result = jedis.expire(key, seconds);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}


	public Boolean exists(String key){

		Jedis jedis = null;
		Boolean result = null;
		try {
			jedis = getJedis();
			result = jedis.exists(key);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}



	public Long del(final String key) {

		Jedis jedis = null;
		Long result = null;
		try {
			jedis = getJedis();
			result = jedis.del(key);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	private Jedis getJedis() {
		return jedisPool.getResource();
	}


	private void closeJedis(Jedis jedis) {
		if (jedis != null) {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(ExceptionUtils.getFullStackTrace(e));
			}
		}
	}


	public Long lpush(String key, String string) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = getJedis();
			result = jedis.lpush(key, new String[]{string});
		} catch (Exception var10) {
			logger.error(ExceptionUtils.getFullStackTrace(var10));
		} finally {
			closeJedis(jedis);
		}
		return result;
	}


	public List<String> blpop(int timeout, String key) {
		Jedis jedis = null;
		List result = null;

		try {
			jedis = getJedis();
			result = jedis.blpop(timeout, key);
		} catch (Exception var10) {
			logger.error(ExceptionUtils.getFullStackTrace(var10));
		} finally {
			closeJedis(jedis);
		}

		return result;
	}
}
