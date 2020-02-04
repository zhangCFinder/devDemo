import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhangc on 2019/9/16.
 */
public class TestReflect {
	@Test
	public void testField() throws Exception {
		MethodTest methodTest = new MethodTest();
		Field allField[] = MethodTest.class.getDeclaredFields();
		for (Field field : allField) {
			field.setAccessible(true);
			String fieldValue = (String) field.get(methodTest);
			System.out.println(fieldValue);
		}
	}


	@Test
	public void testMethod() throws Exception {
		Class classes = Class.forName("MethodTest");
		Method method = classes.getDeclaredMethod("doB");
		method.setAccessible(true);
		System.out.println("isAccessible-----" + method.isAccessible());
		method.invoke(new MethodTest());
	}
}
