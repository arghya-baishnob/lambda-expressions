package com.ab.closure;

public class ClosureExample {
    public static void main(String[] args) {
        int x = 20;

        /**
         * This lambda is passing to p.process(i),
         * but there  the value of x is coming
         * from closure which is took from the scope
         * of lambda expression & it is final.
         */
        doProcess(10, i -> System.out.println(i + x));

    }

    private static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}