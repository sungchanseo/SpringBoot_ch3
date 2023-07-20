package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowired;

class Car {
    Engine engine;
    Door door;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door getDoor() {
        return door;
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
class SportsCar extends Car {}
class Engine{}

class Door{}

public class Main {
    public static void main(String[] args) {
        Car car = new SportsCar();
        System.out.println("car = " + car);
    }

    static Car getCar(){
        return new SportsCar();
    }
}
