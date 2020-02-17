package com.freedom.lambda;

import java.math.BigDecimal;
import java.util.function.*;

public class FunctionInterfaceTest {


    public static void main(String[] args) {
        Predicate <Integer> predicate = x -> x > 180;
        Student student = new Student("9龙", 23, 175);
        System.out.println("9龙的身高高于180吗？：" + predicate.test(student.getStature()));

        Consumer<String> consumer = System.out::println;
        consumer.accept("命运由我不由天");

        Function<Student,String> function = Student ::getName;
        String name = function.apply(student);
        System.out.println("name : " + name);

//        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        Supplier<Integer> supplier = () -> Integer.valueOf(student.getStature());

        System.out.println(supplier.get());

        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println("unaryOperator !true result : " + apply2);

        BinaryOperator<Integer> operator = (x,y) -> x+y;
        Integer integer = operator.apply(20,10);
        System.out.println(integer);


    }
}
