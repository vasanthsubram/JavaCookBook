package spring.aop.profilerExample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // that this class is an aspect
public class BusinessProfilerAspect {

	//defines a pointcut that will match the execution of all public methods
	//in spring.aop.profilerExample package.
	@Pointcut("execution(* spring.aop.profilerExample.*.*(..))")
	public void businessMethods() {
	}

	//@Around advice which will be invoked before and after the business method
	@Around("businessMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("Going to call the method.");
		Object output = pjp.proceed();
		System.out.println("Method execution completed.");
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("Method execution time: " + elapsedTime
				+ " milliseconds.");
		return output;
	}
}