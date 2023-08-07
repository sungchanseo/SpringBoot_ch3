package com.fastcampus.ch3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class AopMain2 {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Config.class);
        MyMath mm = ac.getBean("myMath", MyMath.class);
        mm.add(3, 5);
        mm.add(1, 2, 3);
        System.out.println("mm.multiple(3, 5) = " + mm.multiple(3, 5));

    }
}
@EnableAspectJAutoProxy //AOP자동 설정
@ComponentScan
@Configuration
class Config{

}
@Component
@Aspect
class LoggingAdvice{
    @Around("execution(* com.fastcampus.ch3.aop.MyMath.add(..))")
    public  Object methodClassLog(ProceedingJoinPoint pjp) throws Throwable {
        //target의 메소드 시작 부분에 추가할 코드
        long start = System.currentTimeMillis();
        System.out.println("<<[start]"+pjp.getSignature().getName()+ Arrays.toString(pjp.getArgs()));

        Object result = pjp.proceed(); // target의 메소드를 호출

        //target의 메소드 끝 부분에 추가할 코드
        System.out.println("result = " + result);
        System.out.println("[end]>>"+(System.currentTimeMillis() - start)+"ms");

        return result;
    }
}
@Component
class MyMath{
    int add(int a, int b) {
        int result = a+b;
        return result;
    }

    int add(int a, int b, int c){
        int result = a+b+c;
        return result;
    }

    int subtract(int a, int b) {
        int result = a-b;
        return result;
    }

    int multiple(int a, int b) {
        int result = a*b;
        return result;
    }
}