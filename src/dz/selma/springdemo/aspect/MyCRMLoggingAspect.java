package dz.selma.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName()); 

	@Before("dz.selma.springdemo.aspect.AopExpressions.forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String signature = joinPoint.getSignature().toShortString();
		myLogger.info("========> @Before : calling method " + signature);
	}

}
