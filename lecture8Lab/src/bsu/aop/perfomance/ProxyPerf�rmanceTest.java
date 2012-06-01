package bsu.aop.perfomance;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProxyPerfîrmanceTest {

	public static void main(String[] args) {
		
		BeanFactory factory = getBeanFactory();
		ISimpleBean target = (ISimpleBean)factory.getBean("SimpleBean");
		
		Advisor advisor = new DefaultPointcutAdvisor((Pointcut)factory.getBean("constructPointcut"),
				(NoOpBeforeAdvice)factory.getBean("aspect"));
		runCglibTests(factory);
		runCglibFrozenTests(factory);
		runJdkTests(factory);
	}

	private static void runCglibTests(BeanFactory factory) {
		ISimpleBean proxy = (ISimpleBean)factory.getBean("CGLib1");
		System.out.println("CGLIB Proxy Tests");
		test(proxy);
	}

	private static void runCglibFrozenTests(BeanFactory factory) {
		ISimpleBean proxy = (ISimpleBean)factory.getBean("CGLibFrozen");
		System.out.println("CGLIB (Frozen) Proxy Test");
		test(proxy);
	}

	private static void runJdkTests(BeanFactory factory) {
		ProxyFactory pf = new ProxyFactory();
		ISimpleBean proxy = (ISimpleBean)factory.getBean("JDK");
		System.out.println("JDK Proxy Test");
		test(proxy);
	}
	 private static void test(ISimpleBean bean) {
		    long before = 0;   long after = 0;
		    System.out.println("Testing Advised Method");
		    before = System.currentTimeMillis();
		    for (int x = 0; x < 500000; x++) { bean.advised();}
		    after = System.currentTimeMillis();
		       System.out.println("Took " + (after - before) + " ms");
		       System.out.println("Testing Unadvised Method");
		       before = System.currentTimeMillis();
		       for (int x = 0; x < 500000; x++) {   bean.unadvised(); }
		       after = System.currentTimeMillis();
		    System.out.println("Took " + (after - before) + " ms");
		    System.out.println("Testing equals() Method");
		    before = System.currentTimeMillis();
		    for (int x = 0; x < 500000; x++) {  bean.equals(bean); }
		    after = System.currentTimeMillis();
		         System.out.println("Took " + (after - before) + " ms");
		         System.out.println("Testing hashCode() Method");
		         before = System.currentTimeMillis();
		         for (int x = 0; x < 500000; x++) { bean.hashCode(); }
		         after = System.currentTimeMillis();
		    System.out.println("Took " + (after - before) + " ms");
		    Advised advised = (Advised) bean;
		    System.out.println("Testing Advised.getProxyTargetClass() Method");
		    before = System.currentTimeMillis();
		    for (int x = 0; x < 500000; x++) {  advised.getTargetClass(); }
		    after = System.currentTimeMillis();
		  
		   System.out.println("Took " + (after - before) + " ms");
		   System.out.println(">>>\n");
		  }
		
	 private static BeanFactory getBeanFactory(){
		 ApplicationContext context = new FileSystemXmlApplicationContext(
					"./src/conf/beans.xml");
			return context; 
	 }

}
