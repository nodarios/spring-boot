package pak.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* pak.controllers.MyControllerGreeting.greet*(..))")
    public void myPK() {
    }

    //it is advice (before advice)
    @Before("myPK()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        logger.info("before");
        logger.info("Method Signature: "  + jp.getSignature());
        logger.info("bean name: " + jp.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "execution(* pak.controllers.MyControllerGreeting.greet*(..))", returning = "result")
    public void myAfterAdvice(JoinPoint jp, Object result) {
        logger.info("after returning");
        logger.info("Method Signature: "  + jp.getSignature());
        logger.info("bean name: " + jp.getTarget().getClass().getName());
        logger.info("returns: " + result.toString());
    }

}
