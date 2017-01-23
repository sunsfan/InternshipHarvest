package sunsfan_spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	@Pointcut("execution(** sunsfan_spring.daoImpl.PerformanceImpl.perform(..))")
	public void performance() {

	}

	// //@Before("execution(**
	// sunsfan_spring.daoImpl.PerformanceImpl.perform(..))")
	// @Before("performance()")
	// public void silenceCellPhone() {
	// System.out.println("Silencing cell phone!");
	// }
	//
	// @Before("execution(**
	// sunsfan_spring.daoImpl.PerformanceImpl.perform(..))")
	// public void takeSeats() {
	// System.out.println("Taking seats!");
	// }
	//
	// @After("execution(**
	// sunsfan_spring.daoImpl.PerformanceImpl.perform(..))")
	// public void applause() {
	// System.out.println("CLAP CLAP CLAP!");
	// }
	//
	// @AfterThrowing("execution(**
	// sunsfan_spring.daoImpl.PerformanceImpl.perform(..))")
	// public void demandRefund() {
	// System.out.println("Demanding a refund!");
	// }
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phone!");
			System.out.println("Taking seats!");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund!");
		}
	}
}
