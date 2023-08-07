package com.fastcampus.ch3.di4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.relational.core.sql.FalseCondition;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.util.Arrays;

class Car {
    @Override
    public String toString() {
        return "Car{}";
    }
}

class SportsCar extends Car {
    @Override
    public String toString() {
        return "SportsCar{}";
    }
}

class SportsCar2 extends Car {
    @Override
    public String toString() {
        return "SportsCar2{}";
    }
}
@Configuration
@Import({Config1.class, Config2.class})
//@Import(MyImportSelector.class)
//@EnabledMyAutoConfiguration("test2")
class MainConfig{ @Bean Car car() {return new Car();} }
class Config1{ @Bean Car sportsCar() { return new SportsCar(); }}
class Config2{ @Bean Car sportsCar() { return new SportsCar2(); }}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
@interface EnabledMyAutoConfiguration{
    String value() default "";
}
class MyImportSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attr = AnnotationAttributes.
                fromMap(importingClassMetadata
                        .getAnnotationAttributes(EnabledMyAutoConfiguration.class.getName(), false));
        String mode = attr.getString("value");
        if(mode.equals("test"))
            return new String[] {Config1.class.getName()};
        else
            return new String[]{Config2.class.getName()};
    }
}

@Component
@Conditional(OSCondition.class)
class Engine { @Override public String toString() {return "Engine{}";}}

@Component
@Conditional(OSConditon.class)
class Door {@Override public String toString() { return "Door{}";}}

class OSCondition implements Condition{
    @Override public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
class OSConditon implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        //System.out.println("System.getProperties() = " + System.getProperties());
        return env.getProperty("mode").equals("dev");
        //return false;
    }
}

@EnableConfigurationProperties({MyProperties.class})
//@SpringBootApplication 이 어노테이션은 아래 세 개를 붙인 것과 같다.
@Configuration
//@SpringBootConfiguration //@Configuration과 동일
//@EnableAutoConfiguration //사용하는 라이브러리에 따라 자동으로 컨피규레이션 해줌.
@ComponentScan
public class Main implements CommandLineRunner {
    @Autowired
    MyProperties prop;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("prop.getEmail() = " + prop.getEmail());
        System.out.println("prop.getDomain() = " + prop.getDomain());
    }

    public static void main(String[] args) {

       // ApplicationContext ac = SpringApplication.run(Main.class, args);
//        System.out.println("ac = " + ac);

        //ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class, Config1.class, Config2.class); //자바 설정을 이용하는 AC
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class); //자바 설정을 이용하는 AC
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames); // 빈 목록이 담긴 배열을 정렬
        Arrays.stream(beanDefinitionNames) // 배열을 스트림으로 변환
                .filter(b->!b.startsWith("org"))
                .forEach(System.out::println); //스트림의 요소를 하나씩 꺼내서 출력
        //System.out.println("ac.getBean(\"sportsCar\") = " + ac.getBean("sportsCar"));
//        MyProperties prop = ac.getBean(MyProperties.class);
//        System.out.println("prop.getDomain() = " + prop.getDomain());
//        System.out.println("prop.getEmail() = " + prop.getEmail());
    }
    @Bean
    MyBean myBean() {return new MyBean();}
}

class MyBean{}