package client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 13.05.2010T18:38:07
 *
 * @author ctapobep
 */
public class StartClient {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("clientBeans.xml");
	}
}