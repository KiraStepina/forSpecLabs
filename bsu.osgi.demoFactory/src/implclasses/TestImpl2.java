package implclasses;

import bsu.osgi.demoInterf.DemoInterface;

public class TestImpl2 implements DemoInterface {

	@Override
	public void call() {
		System.out.println("Implementation from factory");

	}

}
