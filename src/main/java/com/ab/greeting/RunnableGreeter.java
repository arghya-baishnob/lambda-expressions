package com.ab.greeting;

public class RunnableGreeter {
    public static void main(String[] args) {

        // Runnable implementation with Anonymous class
        Thread anonymousThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World! from Anonymous Thread");
            }
        });
        anonymousThread.start();

        // Runnable implementation with Lambda Expression
        Thread lambdaThread = new Thread(() -> System.out.println("Hello World! from Lambda Thread"));
        lambdaThread.start();
    }
}
