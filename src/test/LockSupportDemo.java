import java.util.concurrent.locks.LockSupport;

/**
 * Created by zhangc on 2019/12/16.
 */
public class LockSupportDemo {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "被唤醒");
		});
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LockSupport.unpark(thread);
	}
}