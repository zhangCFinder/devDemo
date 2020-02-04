//import com.zhangC.common.utils.InnerClassSingleton;
//import org.junit.Test;
//
//import java.io.*;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
///**
// * Created by zhangc on 2019/7/24.
// */
//public class SingletonTest {
//	@Test
//	public  void destorySingletonByReflect() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//		//通过单例模式获取单例对象innerClassSingleton1，调用构造器一次
//		InnerClassSingleton innerClassSingleton1 = InnerClassSingleton.getInstance();
//		System.out.println(innerClassSingleton1);
//		//通过单例模式获取单例对象innerClassSingleton2
//		InnerClassSingleton innerClassSingleton2 = InnerClassSingleton.getInstance();
//		//观察控制台，这次获得的innerClassSingleton2和innerClassSingleton1是同一个对象，没有调用构造器
//		System.out.println(innerClassSingleton2);
//		//首先拿到万能的Class对象
//		Class<InnerClassSingleton> clazz = InnerClassSingleton.class;
//		//然后拿到构造器，使用这个方法私有的构造器也可以拿到
//		Constructor<InnerClassSingleton> constructor = clazz.getDeclaredConstructor();
//		//设置在使用构造器的时候不执行权限检查
//		constructor.setAccessible(true);
//		//由于没有了权限检查，所以在InnerClassSingleton类外面也可以创建对象了，然后执行方法
//		//观察控制台，私有构造器又被调用了一次，单例模式被攻陷了，执行方法成功。
//		System.out.println(constructor.newInstance());
//	}
//
//
//	@Test
//	public  void destorySingletonByAntiSerializable() throws Exception {
//		InnerClassSingleton o1 = null;
//		InnerClassSingleton o2 = InnerClassSingleton.getInstance();
//
//		FileOutputStream fos = new FileOutputStream("InnerClassSingleton.obj");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(o2);
//		oos.flush();
//		oos.close();
//
//		FileInputStream fis = new FileInputStream("InnerClassSingleton.obj");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		o1 = (InnerClassSingleton) ois.readObject();
//		ois.close();
//
//		System.out.println(o1);
//		System.out.println(o2);
//		System.out.println(o1.equals(o2));
//
//	}
//}
