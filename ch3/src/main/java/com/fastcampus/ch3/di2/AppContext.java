package com.fastcampus.ch3.di2;

import com.fastcampus.ch3.di2.Engine;
import com.fastcampus.ch3.di2.SportsCar;
import com.fastcampus.ch3.di2.Door;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AppContext {
    Map map = new HashMap();

    AppContext(){
        map.put("car", new SportsCar());
        map.put("engine", new Engine());
        map.put("door", new Door());
    }

    AppContext(Class clazz) {
        Object config = null;
        try {
            config = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            for (Annotation anno : m.getDeclaredAnnotations()) {
                if (anno.annotationType() == Bean.class) {
                    try {
                        map.put(m.getName(), m.invoke(config, null));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                    //map.put("car", config.car());
                }
            }
        }
    }
    public Object getBean(Class clazz) {
        for (Object obj : map.values()) {
            if (clazz.isInstance(obj)) {
                return  obj;
            }
        }
        return null;
    }
    public Object getBean(String id) {
        return map.get(id);
    }
}
