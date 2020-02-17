package com.freedom.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCase {
    public static void main(String[] args) {

        //collect(colletors.toList等)
        List<Student> studentList = Stream.of(
                new Student("路飞", 22,174),
                new Student("宏发",40,180),
                new Student("白胡子", 50,170)
        ).collect(Collectors.toList());

        System.out.println(studentList);


        //filter(过滤筛选)，内部就是Predicate接口。惰性求值。
        List<Student> list = studentList.stream().filter(stu -> stu.getStature() <175)
                .collect(Collectors.toList());
        System.out.println(list);


        //map转换功能，内部就是Function接口。惰性求值
        List<String> names = studentList.stream().map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println(names);

        //flatMap 将多个Stream合并为一个Stream。惰性求值

        List<Student> students= new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        List<Student> newstudentList = Stream.of(students, Arrays.asList(new Student("艾斯", 25, 183),
            new Student("雷利", 48, 176))).flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println("flatMap:" +newstudentList);



        //max和min。经常在集合中求最大或最小值，使用流就很方便。及早求值。

    }
}
