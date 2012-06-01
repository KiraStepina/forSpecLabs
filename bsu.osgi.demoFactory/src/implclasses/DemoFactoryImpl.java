package implclasses;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import bsu.osgi.demoInterf.DemoInterface;

public class DemoFactoryImpl implements ServiceFactory<DemoInterface> {
	private static int usageCounter;
	
	@Override
	public DemoInterface getService(Bundle bundle,
			ServiceRegistration<DemoInterface> arg1) {
        System.out.println("QuoteServiceFacvtory created an object of QuoteService for " + bundle.getSymbolicName());
        usageCounter++;
        System.out.println("Number of bundles using QuoteService " + usageCounter);
        DemoInterface interf = new TestImpl2();
        return interf;

	}

	@Override
	public void ungetService(Bundle arg0,
			ServiceRegistration<DemoInterface> arg1, DemoInterface arg2) {
		usageCounter--;		
	}

}
