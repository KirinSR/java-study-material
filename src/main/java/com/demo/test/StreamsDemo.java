package com.demo.test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String a[]){
        List<Integer> nums = Arrays.asList(2,1,5,3,8,7);
// For each inner implementation
        Consumer<Integer> con = integer -> System.out.println(integer);
        nums.forEach(con);
        nums.forEach(n -> System.out.println(n));


// Long impl of Stream api
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n%2 == 0);
        Stream<Integer> s3 = s2.map(n -> n*2);
        int result = s3.reduce( 0, (c,e) -> c+e);

        System.out.println(result);

// Short inline approach of Stream api

        // Filter inner impl
        Predicate<Integer> filter = integer -> integer%2 == 0;
        // Map inner impl
        Function<Integer, Integer> map = integer -> integer*2;

        int res = nums.stream()
                    .filter(n -> n%2 == 0)
                    .map(n -> n*2)
                    .reduce(0, (c,e) -> c + e);

        System.out.println(res);
    }

}