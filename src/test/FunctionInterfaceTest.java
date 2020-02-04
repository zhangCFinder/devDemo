//import com.zhangC.common.utils.FunctionInterface;
//import org.junit.Test;
//
///**
// * Created by zhangc on 2019/7/24.
// */
//public class FunctionInterfaceTest {
//	@Test
//	public void testLambda() {
//		//使用Lambda表达式代替匿名内部类
//		func((Integer x) -> {
//			System.out.println("参数---" + x);
//			return true;
//		});
//
//		func(new FunctionInterface<Integer>() {
//			@Override
//			public boolean test(Integer param) {
//				System.out.println("参数---" + param);
//				return true;
//			}
//		});
//	}
//
//	private void func(FunctionInterface<Integer> functionInterface) {
//		int x = 1;
//		functionInterface.test(x);
//	}
//}
