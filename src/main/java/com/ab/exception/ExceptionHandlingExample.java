package com.ab.exception;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int [] values = {1, 2, 3, 4, 5};
        int key = 0;

        process(values, key, wrapperLambda((v, k) -> System.out.println(v / k)));
    }

    private static void process(int[] values, int key, BiConsumer<Integer, Integer> consumer) {
       for (int i : values) {
           consumer.accept(i, key);
       }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException Exception Caught, " + e.getMessage());
            }
        };
    }
}
