package com.sonu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopDuplicateInMapValue {
    public static void main(String[] args) {
        RestrictedMap<String, Employee> empMap = new RestrictedMap<>();
        Employee e1 = new Employee(1, "sonu");
        Employee e2 = new Employee(2, "sonu");
        Employee e3 = new Employee(3, "sonu");
        Employee e4 = new Employee(4, "sonu");
        Employee e5 = new Employee(5, "sonu");

        System.out.println("******");
        Stream.of(e1, e2, e3).peek(e -> e.equals(e)).forEach(e -> System.out.println(e));
       /* if (!isExist(empMap, e)) {
            empMap.put("sonu", e);

        }

        if (!isExist(empMap, e)) {
            empMap.put("sonu", e);

        }*/
        empMap.put("sonu", e1);
        empMap.put("Rakesh", e1);
        empMap.put("Mohan", e2);
        empMap.put("Rakesh", e3);
        empMap.put("Sashi", e4);
        empMap.put("Vikram", e5);

        System.out.println("*****\t\t" + empMap);

        long l = Stream.of(1, 23, 44, 67, 78, 98).filter(i -> true).peek(i -> System.out.println(i)).count();
        Stream.of(1, 23, 44, 67, 78, 98).limit(5).forEach(System.out::println);


    }

   /* static boolean isExist(Map<String, Employee> empMap, Employee emp) {
        Set<String> keys = empMap.keySet();
        boolean flag = false;
        for (String empl : keys) {
            Employee emple = empMap.get(empl);
            if (emp.equals(emple))
                flag = true;
            break;
        }

        return flag;
    }*/


}
