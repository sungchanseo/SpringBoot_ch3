package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws  Exception{
        Car car = new Car();
        Class carClass= car.getClass(); //1. 객체에서 Class객체 얻기
        carClass = Car.class; //2 . 객체 리터럴에서 Class객체 얻기
        carClass = Class.forName("com.fastcampus.ch3.di1.Car"); //클래스 객체의 설계도를 얻음

        //1. 설계도 객체에서 객체 생성하기 '
        Car car2 = (Car) carClass.newInstance();
        System.out.println("car2 = " + car2);

        //2. 클래스에 선언한 멤버변수와 메소드 목록 얻기
        Field[] fields = carClass.getFields();
//        Method[] methods = carClass.getDeclaredMethods();
        Method[] methods = carClass.getMethods();

        System.out.println("필드 목록 보기 ");
        for(Field mv : fields) System.out.println(mv.getName());
        System.out.println("메소드 목록 보기 ");
        for(Method mv : methods) System.out.println(mv.getName());

        System.out.println("카 클래스 보기");
        Method method = carClass.getMethod("setEngine", Engine.class);
        method.invoke(car, new Engine()); //car.setEngine(new Engine());
        System.out.println("car = " + car);

        //3. mv에 set 붙여서 setter호출하기
        for (Field mv : fields) {
            System.out.println("mv = " + mv);
            String methodName = "set" + StringUtils.capitalize(mv.getName());
            System.out.println("methodName = " + methodName);
            method = carClass.getMethod(methodName, mv.getType()); // carClass.seetMethod("setEngine", Engine.class);
            method.invoke(car, mv.getType().newInstance()); // car.setEngine(new Engine());

        }
        System.out.println("car = " + car);

        //4. mv에 @Autowired 인지 확인하기

        for (Field mv : fields) {
            Annotation[] annoArr = mv.getDeclaredAnnotations();
            for (Annotation anno : annoArr) {
                System.out.println("mv.getName = " + mv.getName());
                System.out.println("anno.annotationType().getSigners() = " + anno.annotationType().getSigners());
                System.out.println(anno.annotationType()== Autowired.class);

            }
        }

    }



}
