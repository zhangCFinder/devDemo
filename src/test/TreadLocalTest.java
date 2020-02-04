/**
 * Created by zhangc on 2019/6/11.
 */

import java.util.HashMap;
import java.util.Map;


public class TreadLocalTest {

//	static ThreadLocal<HashMap> threadLocal = new ThreadLocal<HashMap>() {
//
//		@Override
//
//		protected HashMap initialValue() {
//
//			System.out.println(Thread.currentThread().getName() + "initialValue");
//
//			return new HashMap();
//
//		}
//
//	};


	public static class T1 implements Runnable {

//		private final static Map map = new HashMap();
		//		private  static Map map ;
		int id;

		public T1(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			 Map map = new HashMap();
//			Map map = threadLocal.get();

			for (int i = 0; i < 5; i++) {
				map.put(i + Thread.currentThread().getName(), i + id * 100);
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
				}
			}
			System.out.println(Thread.currentThread().getName()
					+ "# map.size() =" + map.size() + " # " + map);
		}
	}

	public static void main(String[] args) {

		Thread[] runs = new Thread[20];
		T1 t = new T1(1);
		for (int i = 0; i < runs.length; i++) {
			runs[i] = new Thread(t);
		}
		for (int i = 0; i < runs.length; i++) {
			runs[i].start();
		}
	}
}