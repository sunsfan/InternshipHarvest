package com.sunsfan.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
	private Jedis jedis;

	@Before
	public void setup() {
		// 连接redis服务器127.0.0.1：6379
		jedis = new Jedis("127.0.0.1", 6379);
		// 权限认证
		// jedis.auth("");
	}

	// redis存储字符串
	//@Test
	public void testString() {
		// 添加数据
		jedis.set("sunsfan", "jinx");
		System.out.println(jedis.get("sunsfan"));

		jedis.append("sunsfan", " is my lover");
		System.out.println(jedis.get("sunsfan"));

		jedis.del("sunsfan");
		System.out.println(jedis.get("sunsfan"));

		// 设置多个键值对
		jedis.mset("name", "ashe", "age", "20", "type", "adc");
		jedis.incr("age");
		System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("type"));
	}

	// redis操作map
	//@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "jinx");
		map.put("age", "20");
		map.put("type", "adc");
		jedis.hmset("sunteng", map);

		List<String> rsmap = jedis.hmget("sunteng", "name", "age", "type");
		System.out.println(rsmap);

		// 删除map中的某个键值
		jedis.hdel("sunteng", "age");
		System.out.println(jedis.hmget("sunteng", "age")); // 因为删除了，所以返回的是null
		System.out.println(jedis.hlen("sunteng")); // 返回key为user的键中存放的值的个数2
		System.out.println(jedis.exists("sunteng"));// 是否存在key为user的记录 返回true
		System.out.println(jedis.hkeys("sunteng"));// 返回map对象中的所有key
		System.out.println(jedis.hvals("sunteng"));// 返回map对象中的所有value

		Iterator<String> iter = jedis.hkeys("sunteng").iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + jedis.hmget("sunteng", key));
		}
	}

	/**
	 * jedis操作List
	 */
	//@Test
	public void testList() {
		// 开始前，先移除所有的内容
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		// 先向key java framework中存放三条数据
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");
		// 再取出所有数据jedis.lrange是按范围取出，
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("java framework", 0, -1));

		jedis.del("java framework");
		jedis.rpush("java framework", "spring");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
	}

	/**
	 * jedis操作Set
	 */
	//@Test
	public void testSet() {
		// 添加
		jedis.srem("user", "xinxin","ling","zhangxinxin","liuling");
		jedis.sadd("user", "thresh");
		jedis.sadd("user", "gnar");
		jedis.sadd("user", "teemo");
		jedis.sadd("user", "sivir");
		jedis.sadd("user", "shen");
		// 移除noname
		jedis.srem("user", "shen");
		System.out.println(jedis.smembers("user"));// 获取所有加入的value
		System.out.println(jedis.sismember("user", "shen"));// 判断 who
															// 是否是user集合的元素
		System.out.println(jedis.srandmember("user"));
		System.out.println(jedis.scard("user"));// 返回集合的元素个数
	}

	//@Test
	public void test() throws InterruptedException {
		// jedis 排序
		// 注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
		jedis.del("a");// 先清除数据，再加入数据进行测试
		jedis.rpush("a", "1");
		jedis.lpush("a", "6");
		jedis.lpush("a", "3");
		jedis.lpush("a", "9");
		System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
		System.out.println(jedis.sort("a")); // [1, 3, 6, 9] //输入排序后结果
		System.out.println(jedis.lrange("a", 0, -1));
	}

	@Test
	public void testRedisPool() {
		RedisUtil.getJedis().set("newname", "中文测试");
		System.out.println(RedisUtil.getJedis().get("newname"));
	}
}
