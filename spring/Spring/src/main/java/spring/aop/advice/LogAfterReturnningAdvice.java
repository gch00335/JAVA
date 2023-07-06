package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturnningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("[" + method.getName() + "] ´Ù ³¡³µ¾î¿ä~~~~^^");
		
	}

}
