package me.frenchline.spring52;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    /* Advice 구현 */
    /* 어떤 메소드 실행 전후로 */
    @Around("bean(simpleEventService)") //bean이 가지고 있는 모든 public 메서드에 적용된다
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint: Advice가 적용되는 지점(Target의 해당 메서드)
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    /* 어떤 메소드가 실행되기 이전 */
    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hello");
    }

}
