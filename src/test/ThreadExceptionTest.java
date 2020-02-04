/**
 * Created by zhangc on 2019/12/24.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Function:线程池异常测试
 *
 * @author crossoverJie
 * Date: 2019-03-07 20:35
 * @since JDK 1.8
 */
public class ThreadExceptionTest {

//	private final static Logger LOGGER = LoggerFactory.getLogger(ThreadExceptionTest.class);


	public static void main(String[] args) throws InterruptedException {

		ExecutorService execute = new ThreadPoolExecutor(1, 1,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		execute.execute(new Run1());

		TimeUnit.SECONDS.sleep(5);


		execute.execute(new Run2());

		//TimeUnit.SECONDS.sleep(5);
		//
		//execute.execute(new Run2());
		//execute.shutdown();

	}


	private static class Run2 implements Runnable {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				count++;
				System.out.println(Thread.currentThread().getName() + "-------222-------------{}" + count);

				if (count == 10) {
					try {
						System.out.println(1 / 0);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	private static class Run1 implements Runnable {


		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "=====11=======" + Thread.currentThread().getState());
		}
	}
}
