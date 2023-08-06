package com.fastcampus.ch3.di2;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

class Car{
    @Autowired Engine engine; //byType으로 자동검색하여 주입.
    @Resource Door door; //byName으로 자동검색하여 주입.


    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
class SportsCar extends Car {
    @Override
    public String toString() {
        return "SportsCar{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}

class Engine{}
class Door{}
public class Main {
    public static void main(String[] args) {
        //AppContext(Class clazz) - 설정화일 자바클래스를 지정
        AppContext ac = new AppContext(AppConfig.class);
        Car car = (Car) ac.getBean("car"); //byName
        Car car2 = (Car) ac.getBean(Car.class); //byType
        Engine engine = (Engine) ac.getBean("engine");
        Door door = (Door) ac.getBean(Door.class);

        //빈들 끼리의 관계를 수동으로 설정함.
//        car.setEngine(engine);
//        car.setDoor(door);

        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);
        System.out.println("door = " + door);
        System.out.println("engine = " + engine);


    }
}
