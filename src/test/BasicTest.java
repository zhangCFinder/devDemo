import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhangc on 2019-1-17.
 */
public class BasicTest {

	@Test
	public void testThreadLocal() {
		ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>() {
			@Override
			protected Integer initialValue() {
				return 0;
			}
		};
		numberContainer.set(2);
		System.out.println(numberContainer.get() + 1);
	}

	@Test
	public void testW() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		String a = "";
		System.out.println((a.getBytes().length + 2) * 356);
		Class clazz = BasicTest.class;
		Constructor c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		Object o1 = c.newInstance();


	}


	@Test
	public void testMapRemove() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "value1");
		map.put("2", "value2");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			if("2".equals(entry.getKey())){
				map.remove("1");
			}
		}
		System.out.println(map.size());
	}


	@Test
	public void testListRemove() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("2".equals(item)) {
//				list.remove(item);
				iterator.remove();
			}
		}
		System.out.println(list.size());
	}


	@Test
	public void testReplace() {
		String str = "{\"msg\":\"\",\"code\":\"\",\"data\":\"[{\\\"show_sold_num\\\":33,\\\"ticketIncomeRT\\\":1450.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.1138,\\\"ticketIncomeZb\\\":0.366717,\\\"numPreShow\\\":2.7500,\\\"showNumZb\\\":0.1667},{\\\"show_sold_num\\\":27,\\\"ticketIncomeRT\\\":1160.00,\\\"normal_show_num\\\":3,\\\"seatRate\\\":0.0583,\\\"ticketIncomeZb\\\":0.293374,\\\"numPreShow\\\":2.2500,\\\"showNumZb\\\":0.2500},{\\\"show_sold_num\\\":15,\\\"ticketIncomeRT\\\":517.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.1389,\\\"ticketIncomeZb\\\":0.487736,\\\"movieName\\\":\\\"绿皮书\\\",\\\"numPreShow\\\":2.1429,\\\"showNumZb\\\":0.1429},{\\\"show_sold_num\\\":16,\\\"ticketIncomeRT\\\":465.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.1151,\\\"ticketIncomeZb\\\":0.399142,\\\"numPreShow\\\":2.2857,\\\"showNumZb\\\":0.2857},{\\\"show_sold_num\\\":7,\\\"ticketIncomeRT\\\":435.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.0307,\\\"ticketIncomeZb\\\":0.110015,\\\"numPreShow\\\":0.5833,\\\"showNumZb\\\":0.1667},{\\\"show_sold_num\\\":14,\\\"ticketIncomeRT\\\":380.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.0686,\\\"ticketIncomeZb\\\":0.326180,\\\"numPreShow\\\":2.0000,\\\"showNumZb\\\":0.2857},{\\\"show_sold_num\\\":8,\\\"ticketIncomeRT\\\":314.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.1311,\\\"ticketIncomeZb\\\":0.079413,\\\"numPreShow\\\":0.6667,\\\"showNumZb\\\":0.0833},{\\\"show_sold_num\\\":6,\\\"ticketIncomeRT\\\":267.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0588,\\\"ticketIncomeZb\\\":0.067527,\\\"movieName\\\":\\\"你是我生命中的一首歌\\\",\\\"numPreShow\\\":0.5000,\\\"showNumZb\\\":0.0833},{\\\"show_sold_num\\\":6,\\\"ticketIncomeRT\\\":236.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.0243,\\\"ticketIncomeZb\\\":0.059686,\\\"movieName\\\":\\\"人间·喜剧\\\",\\\"numPreShow\\\":0.5000,\\\"showNumZb\\\":0.1667},{\\\"show_sold_num\\\":7,\\\"ticketIncomeRT\\\":210.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.0387,\\\"ticketIncomeZb\\\":0.180258,\\\"movieName\\\":\\\"你是我生命中的一首歌\\\",\\\"numPreShow\\\":1.0000,\\\"showNumZb\\\":0.2857},{\\\"show_sold_num\\\":5,\\\"ticketIncomeRT\\\":185.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0463,\\\"ticketIncomeZb\\\":0.174528,\\\"movieName\\\":\\\"地久天长\\\",\\\"numPreShow\\\":0.7143,\\\"showNumZb\\\":0.1429},{\\\"show_sold_num\\\":4,\\\"ticketIncomeRT\\\":148.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0370,\\\"ticketIncomeZb\\\":0.139623,\\\"numPreShow\\\":0.5714,\\\"showNumZb\\\":0.1429},{\\\"show_sold_num\\\":4,\\\"ticketIncomeRT\\\":140.00,\\\"normal_show_num\\\":2,\\\"seatRate\\\":0.0102,\\\"ticketIncomeZb\\\":0.132075,\\\"numPreShow\\\":0.5714,\\\"showNumZb\\\":0.2857},{\\\"show_sold_num\\\":4,\\\"ticketIncomeRT\\\":110.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0533,\\\"ticketIncomeZb\\\":0.094421,\\\"numPreShow\\\":0.5714,\\\"showNumZb\\\":0.1429},{\\\"show_sold_num\\\":2,\\\"ticketIncomeRT\\\":92.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0100,\\\"ticketIncomeZb\\\":0.023268,\\\"movieName\\\":\\\"警告\\\",\\\"numPreShow\\\":0.1667,\\\"showNumZb\\\":0.0833},{\\\"show_sold_num\\\":1,\\\"ticketIncomeRT\\\":45.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0111,\\\"ticketIncomeZb\\\":0.042453,\\\"numPreShow\\\":0.1429,\\\"showNumZb\\\":0.1429},{\\\"show_sold_num\\\":1,\\\"ticketIncomeRT\\\":25.00,\\\"normal_show_num\\\":1,\\\"seatRate\\\":0.0111,\\\"ticketIncomeZb\\\":0.023585,\\\"movieName\\\":\\\"精灵怪物：疯狂之旅\\\",\\\"numPreShow\\\":0.1429,\\\"showNumZb\\\":0.1429}]\"}";
		System.out.println(str.replace("\\",""));
		ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
	}
	private  int count =0;

	@Test
	public void testVolatile(){
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new SynchronizedDemo(count));
			thread.start();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStringReplace(){
		String s = "([])";
		s = s.replaceAll("\\[\\]", "");
		System.out.println(s);
	}


}
