import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class ServiceTest {
	
	@Test
	public void runTest() {
		      ApplicationContext ctx = new  FileSystemXmlApplicationContext("src/test/resources/context.xml");
		      IService service = (IService) ctx.getBean("service");
		      service.insertProduct(new Product());   
		    }

}
