package dz.selma.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

	@Pointcut("execution(* dz.selma.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* dz.selma.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* dz.selma.springdemo.dao.*.*(..))")
	public void forDAOPackage() {}

	// create pointcut : include controller, dao, service packages
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage())")
	public void forAppFlow() {}
}
