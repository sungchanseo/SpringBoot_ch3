package com.fastcampus.ch3.di2;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean public Car car(){
        //map.put("car", new Car()); xml의 경우
        //<bean id = "car" class="com.fastcampus.ch3.di2.Car">
        Car car = new Car();
        return car;
    }
    @Bean public Engine engine(){return new Engine();}
    @Bean public Door door() { return new Door();}
}
