import org.junit.Test;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterNameDiscoverer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by zhangc on 2019/7/24.
 */
public class MethodTest {
	String a;
	private String b = "privatebbbbbbbbbbbbbbbbbb";

	public void doA(String s,Integer i) {
		System.out.println("from a");
	}

	private void doB() {
		System.out.println("from b");
	}

	@Test
	public  void testMethod() throws Exception {
//		Class classes = Class.forName("MethodTest");
//		Method method = classes.getDeclaredMethod("doB");
//		System.out.println("isAccessible-----"+method.isAccessible());
//		method.invoke(new MethodTest());

		MethodTest methodTest = new MethodTest();
		Field allField[] = MethodTest.class.getDeclaredFields();
		for(Field field:allField){
			System.out.println(field);
			String fieldValue = (String) field.get(methodTest);
			System.out.println(fieldValue);
		}
	}


	@Test
	public  void testMethodParameter() throws Exception {

		Method method = MethodTest.class.getMethod("doA", String.class, Integer.class);
		MethodParameter nameParameter = new MethodParameter(method, 0);
		MethodParameter ageParameter = new MethodParameter(method, 1);

		// 打印输出：
		// 使用Parameter输出
		Parameter nameOriginParameter = nameParameter.getParameter();
		Parameter ageOriginParameter = ageParameter.getParameter();
		System.out.println("===================源生Parameter结果=====================");
		System.out.println(nameOriginParameter.getType() + "----" + nameOriginParameter.getName());
		System.out.println(ageOriginParameter.getType() + "----" + ageOriginParameter.getName());
		System.out.println("===================MethodParameter结果=====================");
		System.out.println(nameParameter.getParameterType() + "----" + nameParameter.getParameterName());
		System.out.println(ageParameter.getParameterType() + "----" + ageParameter.getParameterName());
		System.out.println("==============设置上ParameterNameDiscoverer后MethodParameter结果===============");
		ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
		nameParameter.initParameterNameDiscovery(parameterNameDiscoverer);
		ageParameter.initParameterNameDiscovery(parameterNameDiscoverer);
		System.out.println(nameParameter.getParameterType() + "----" + nameParameter.getParameterName());
		System.out.println(ageParameter.getParameterType() + "----" + ageParameter.getParameterName());
	}
}
