import org.junit.Test;

import java.util.*;

/**
 * Created by zhangc on 2020/1/1.
 */
public class MapListTest {
	@Test
	public void testHashMap(){
		Map map = new HashMap();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(1<<30);
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("2".equals(item)) {
//				list.re
			}
		}
	}
}
