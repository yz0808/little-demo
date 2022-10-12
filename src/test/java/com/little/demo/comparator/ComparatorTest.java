package com.little.demo.comparator;

import com.yangzhong.spring.boot.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yangzhong
 * @Date 2021-06-08 21:49
 * @Description 描述
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Person p1 = new Person(10);
        Person p2 = new Person(20);
        Person p3 = new Person(30);

        List<Person> testList = new ArrayList<>();
        testList.add(p1);
        testList.add(p3);
        testList.add(p2);
        List<Person> collect = testList.stream().sorted(Comparator.comparing(Person::getAge, Comparator.reverseOrder())).collect(Collectors.toList());
        for (Person person : collect) {
            System.out.println(person.getAge());
        }
    }

}
