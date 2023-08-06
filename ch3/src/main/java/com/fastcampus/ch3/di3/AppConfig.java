package com.fastcampus.ch3.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //일반 클래스가 아니라 설정 클래스임을 명시
@ComponentScan
public class AppConfig {
//    @Bean
//    @Scope("singleton")
//    Car car(){
//        return new Car();
//    }
//    @Bean
//    //@Scope("singleton") 기본이 싱글톤 타입 - 이미 만들어진 객체를 불러온다.
//    @Scope("prototype") //프로토타입일 경우 매번 새로운 객체를 리턴함.
//    Engine engine(){
//        return new Engine();
//    }
//
//    @Bean
//    Door door(){
//        return new Door();
//    }
}
