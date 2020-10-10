package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task018Impl implements Task018 {
    /**
     * Check is annotation present in the following object.
     *
     * @param toCheck          object to check
     * @param annotationToFind annotation to look for
     * @return is annotation presents
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        //On package
        Package myPackage = Task018.class.getPackage();
        Annotation[] myPackageAnnotations = myPackage.getAnnotations();
        for (Annotation a : myPackageAnnotations) {
            if (a.annotationType().equals(annotationToFind)) {
                return true;
            }
        }
        //On type
        Annotation[] dA = toCheck.getClass().getAnnotations();
        for (Annotation a : dA) {
            if (a.annotationType().equals(annotationToFind)) {
                return true;
            }
        }
        //On field
        Field[] fields = toCheck.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }
        //On method
        Method[] methods = toCheck.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (Annotation[] ar : parameterAnnotations) {
                for (Annotation a : ar) {
                    if (a.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }
        }
        //On constructor
        Constructor[] constructors = toCheck.getClass().getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            Annotation[] annotations = constructor.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    return true;
                }
            }
        }
        return false;
    }
}
