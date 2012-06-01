package bsu.osgi.demofactory;

import implclasses.DemoFactoryImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bsu.osgi.demoInterf.DemoInterface;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration<?> demoServiceRegistration;


	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
        DemoFactoryImpl factory = new DemoFactoryImpl();
        demoServiceRegistration =
             context.registerService(DemoInterface.class.getName(), factory, null);

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		demoServiceRegistration.unregister();
	}

}
