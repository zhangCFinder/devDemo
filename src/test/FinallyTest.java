import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangc on 2019/10/19.
 */
public class FinallyTest {

	@Test
	public void testFinally() {
		int n = 4;
//		System.out.println((2>>>=1)!=0);
		System.out.println( n=n >>> 1);
//		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//		threadLocal.set(1);

//		System.out.println(testFinally2());
		Lock lock = new ReentrantLock();
	}

	public static int testFinally3() {
		try {
			System.out.println("start");
			Integer.parseInt("testFinally3");
			System.out.println("never run");
		} catch (Exception e) {
			System.out.println("catch block 3");
			return iamReturn();
		} finally {
			System.out.println("finally block 3");
		}
		return 31;
	}

	public static int iamReturn() {
		System.out.println("return block");
		return 666;
	}

	public static int testFinally2() {
		try {
			System.out.println("start");
			return 21;
		} catch (Exception e) {
			System.out.println("catch block 2");
		} finally {
			System.out.println("finally block 2");
		}
		return 22;
	}


}
