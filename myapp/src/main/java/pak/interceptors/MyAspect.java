package pak.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pak.dtos.MyEntityDto;

@Aspect
@Component
@Slf4j
public class MyAspect {

    //@Pointcut("within(@org.springframework.stereotype.Service *)")
    //public void withinServiceClass() {
    //}

    //@Pointcut("within(pak.service..*)")
    //public void withinServicePackage() {
    //}

    //@Pointcut("execution(public * *(..))")
    //public void publicMethodExecution() {
    //}

    @Pointcut("execution(* pak.controllers.MyControllerDb.addMyEnt*(..))")
    public void addMyEntityMethodExecution() {
    }

    @Pointcut("@annotation(pak.annotation.MyAnnotation)")
    private void hasMyAnnotation() {
    }

    // it is advice (before advice)
    @Before("addMyEntityMethodExecution()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        log.info("before");
        log.info("Method Signature: " + jp.getSignature());
        log.info("bean name: " + jp.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "addMyEntityMethodExecution()", returning = "result")
    public void myAfterAdvice(JoinPoint jp, Object result) {
        log.info("after returning");
        log.info("Method Signature: " + jp.getSignature());
        log.info("bean name: " + jp.getTarget().getClass().getName());
        log.info("returns: " + result.toString());
    }

    @Around("addMyEntityMethodExecution() && hasMyAnnotation())")
    public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        Class<?> returnType = ((MethodSignature) signature).getReturnType();
        MyEntityDto newGreetingDto = (MyEntityDto) returnType.getConstructor().newInstance();

        Object proceed = joinPoint.proceed();
        MyEntityDto myEntityDto = (MyEntityDto) proceed;
        log.info("around");
        log.info("myEntityDto: {}", myEntityDto);
        return proceed;
    }

}
