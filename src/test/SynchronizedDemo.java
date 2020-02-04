/**
 * Created by zhangc on 2019/6/25.
 */
public class SynchronizedDemo implements Runnable {
	public static volatile  int count ;

	public SynchronizedDemo(int count){
		count = this.count;
	}
	@Override
	public void run() {
//		synchronized (SynchronizedDemo.class) {
			for (int i = 0; i < 100; i++)
				count++;
//		}
		System.out.println("result: " + count);
	}




}
