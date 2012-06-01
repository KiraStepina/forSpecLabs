package bsu.aop.perfomance;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class TestPoint extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class arg1) {
		  return ("advised".equals(method.getName()));
	}

}
