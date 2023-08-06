package com.fastcampus.ch3.di3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Map;
@Component
class Car{
//    @Autowired
//    @Resource(name = "superEngine")
//    @Autowired //byType로 검색
//    @Qualifier("superEngine")
    @Inject()  //@Autowird와 동일하다. inject에는 required=false가 없다.
    Engine engine;

//    @Autowired
    @Resource(name = "door")
    Door door;

//    @Autowired
//    public Car(Engine[] engine) {
//        this.engine = engine;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
//@Component
class Engine{}

//@Component
//class SuperEngine extends Engine{}

@Component
class TurboEngine extends Engine{}

@Component
class Door{}

public class Main {
    public static void main(String[] args) {
        //AC를 생성 - AC의 설정화일은 AppConfig.class 자바설정.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = (Car) ac.getBean("car");
        System.out.println("car = " + car);
//
    }
}
