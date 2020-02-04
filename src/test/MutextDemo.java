import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangc on 2019/11/3.
 */
public class MutextDemo {
	private static Lock mutex = new ReentrantLock();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					mutex.lock();
					try {
						System.out.println("Thread Sleepped");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						mutex.unlock();
					}
				}
			});

			thread.start();
		}
	}
}

