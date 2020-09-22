package pak.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {

    @Pointcut("execution(* pak.controllers.MyControllerGreeting.greet*(..))")
    public void myPK() {
    }

    //it is advice (before advice)
    @Before("myPK()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        log.info("before");
        log.info("Method Signature: "  + jp.getSignature());
        log.info("bean name: " + jp.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "execution(* pak.controllers.MyControllerGreeting.greet*(..))", returning = "result")
    public void myAfterAdvice(JoinPoint jp, Object result) {
        log.info("after returning");
        log.info("Method Signature: "  + jp.getSignature());
        log.info("bean name: " + jp.getTarget().getClass().getName());
        log.info("returns: " + result.toString());
    }

}
