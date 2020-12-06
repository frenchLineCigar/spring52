package me.frenchline.spring52;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    /* Advice 구현 */
    //이 Advice를 어떻게 적용할 것인가?를 정의
    @Around("@annotation(PerfLogging)") //메서드를 감싸는(Around) 형태로 (Pointcut 이름)
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint: Advice가 적용되는 지점(Target의 해당 메서드)
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

}
