package bsu.aop.perfomance;

public class SimpleBean implements ISimpleBean {

	private long dummy = 0;

	@Override
	public void advised() {
		dummy = System.currentTimeMillis();
	}

	@Override
	public void unadvised() {
		dummy = System.currentTimeMillis();
	}
}
