package com.saksham;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer miniResult =
                new MiniStream<>(numbers)
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum);

        Integer streamResult =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum);

        System.out.println("MiniStream Result : " + miniResult);
        System.out.println("JDK Stream Result : " + streamResult);

        System.out.println(
                "Equal? " + miniResult.equals(streamResult)
        );
    }
}