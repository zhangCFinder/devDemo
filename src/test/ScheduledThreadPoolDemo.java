import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangc on 2019/12/23.
 */
public class ScheduledThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {

		//创建一个ScheduledThreadPoolExecutor对象
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		//计划在某段时间后运行
		System.out.println("Current Time = "+new Date());
		WorkerThread worker = new WorkerThread("do heavy processing");
		// schedule task to execute at fixed rate
		scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 1, TimeUnit.SECONDS);

		//添加一些延迟让调度程序产生一些线程
		Thread.sleep(30000);
		System.out.println("Current Tim e = "+new Date());
		//关闭线程池
		scheduledThreadPool.shutdown();
		while(!scheduledThreadPool.isTerminated()){
			//等待所有任务完成
		}
		System.out.println("Finished all threads");
	}

}
