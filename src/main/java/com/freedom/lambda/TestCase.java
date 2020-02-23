package com.freedom.lambda;

import java.util.*;
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
        List<Student> newstudentList = Stream.of(students, Arrays.asList(
                new Student("艾斯", 25, 183),
                new Student("雷利", 48, 176))).
                flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println("flatMap:" +newstudentList);



        //max和min。经常在集合中求最大或最小值，使用流就很方便。及早求值。
        Optional<Student> max = students.stream().max(Comparator.comparing(stu -> stu.getAge()));

        Optional<Student> min = students.stream().min(Comparator.comparing(stu -> stu.getAge()));
        //判断是否有值
        if (max.isPresent()) {
            System.out.println("max age:" + max.get());
        }
        if (min.isPresent()){
            System.out.println("min age:" + min.get());
        }


        //count 统计功能，一般都是结合filter使用，因为先筛选出我们需要的再统计即可。及早求值。

        long count = students.stream().filter(s1 -> s1.getAge() < 45).count();
        System.out.println("年龄小于45岁的人数是 ： " + count);

        //reduce 操作 可以实现从一组值中生成一个值。  count、min和max方法，因为常用而被纳入标准库中。
        // 事实上，这些方法都是reduce操作
        Integer reduce = Stream.of(1,2,3,4).reduce(0,(acc,x) -> acc+x);//累加器
        Integer reduce2 = Stream.of(1,2,3,4).reduce(1,(acc,x) -> acc*x);//累乘器

        System.out.println(reduce);


    }
}
