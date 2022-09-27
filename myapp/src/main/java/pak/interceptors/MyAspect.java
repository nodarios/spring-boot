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
import pak.dtos.GreetingDto;

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

    @Pointcut("execution(* pak.controllers.MyControllerAspect.processReq*(..))")
    public void processRequestMethodExecution() {
    }

    @Pointcut("@annotation(pak.annotation.MyAnnotation)")
    private void hasMyAnnotation() {
    }

    // it is advice (before advice)
    @Before("processRequestMethodExecution()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        log.info("before");
        log.info("Method Signature: " + jp.getSignature());
        log.info("bean name: " + jp.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "processRequestMethodExecution()", returning = "result")
    public void myAfterAdvice(JoinPoint jp, Object result) {
        log.info("after returning");
        log.info("Method Signature: " + jp.getSignature());
        log.info("bean name: " + jp.getTarget().getClass().getName());
        log.info("returns: " + result.toString());
    }

    @Around("processRequestMethodExecution() && hasMyAnnotation())")
    public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        Class<?> returnType = ((MethodSignature) signature).getReturnType();
        GreetingDto newGreetingDto = (GreetingDto) returnType.getConstructor().newInstance();

        Object proceed = joinPoint.proceed();
        GreetingDto greetingDto = (GreetingDto) proceed;
        log.info("around");
        log.info("greetingDto: {}", greetingDto);
        return proceed;
    }

}
