/**
 * Created by zhangc on 2019/12/18.
 */
import java.util.Date;

/**
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 */
public class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
	}

	private void processCommand() {
		try {
			Thread.sleep(10000);
			String json = "";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		return this.command;
	}
}
