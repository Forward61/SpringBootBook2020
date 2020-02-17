package com.freedom.lambda;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int age;
    private int stature;
    private SpecialityEnum specialityEnum;

    public Student(String name, int age, int stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }
}
