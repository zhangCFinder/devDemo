import com.zhangC.aop.execution.Iface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangc on 2019/9/18.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAop {
	@Autowired
	private Iface iface;

	@Test
	public void testAopBySpring(){
		iface.say();
	}

	@Test
	public void testCustomAnno(){
		iface.saybyCoustomAnno();
	}

}
