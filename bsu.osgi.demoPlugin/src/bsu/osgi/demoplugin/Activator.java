package bsu.osgi.demoplugin;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import bsu.osgi.demo.Implement.TestImplements;
import bsu.osgi.demoInterf.DemoInterface;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		DemoInterface interf = new TestImplements();
		context.registerService(DemoInterface.class.getName(), interf, null);
		System.out.println("Registering done");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		
	}

}
