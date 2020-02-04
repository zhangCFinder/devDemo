import java.util.concurrent.*;

/**
 * Created by zhangc on 2019/12/22.
 */
public class FutrureTaskExample {
	public static void main(String[] args) throws Exception {

		long t1 = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		FutureTask<String> heatUpWaterFuture = new FutureTask<String>(new Callable<String>() {
			@Override


			public String call() throws Exception {
				System.out.println("烧开水...");
				Thread.sleep(3000);
				return "ok";

			}

		});


		FutureTask<String> cookMealsFuture = new FutureTask<String>(new Callable<String>() {
			@Override


			public String call() throws Exception {
				System.out.println("煮饭...");
				Thread.sleep(5000);
				return "ok";

			}

		});

		executorService.submit(heatUpWaterFuture);
		executorService.submit(cookMealsFuture);

		System.out.println("炒菜...");

		Thread.sleep(2000);

		System.out.println("菜炒好了了");

		if (heatUpWaterFuture.get(5000, TimeUnit.SECONDS) == "ok"
				&& cookMealsFuture.get(5000, TimeUnit.SECONDS) == "ok") {
			System.out.println("开饭了...");

		}

		long t2 = System.currentTimeMillis();
		System.out.println("做饭用时:" + (t2 - t1) + "ms");


	}
}
