package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		
		// 遺�媛� �뾽臾� (�떆媛� 痢≪젙)
		long start = System.currentTimeMillis();
		
		// 二쇱뾽遺� 遺�瑜닿린
		Object result = invocation.proceed();
		
		// 遺�媛� �뾽臾� (�떆媛� 痢≪젙)
		long end = System.currentTimeMillis();
		
		String message = (end - start)+ "ms 걸렸습니다.";
		System.out.println(message);
		
		return result;
	}

}
