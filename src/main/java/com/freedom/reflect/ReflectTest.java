package com.freedom.reflect;

public class ReflectTest {

    public static void main(String[] args) {

        //
        try {
            Class clazz = Class.forName("com.freedom.reflect.User");
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
