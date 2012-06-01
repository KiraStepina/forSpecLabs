package bsu.osgi.demo.Implement;
import bsu.osgi.demoInterf.DemoInterface;

public class TestImplements implements DemoInterface {

	@Override
	public void call() {
		System.out.println("Implementing pass!");
	}

}
