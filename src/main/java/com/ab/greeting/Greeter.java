package com.ab.greeting;

public class Greeter {

    private void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {

        // Interface implementation with Anonymous class
        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello World!");
            }
        };

        // Interface implementation with Lambda Expression
        Greeting lambdaGreeting = () -> System.out.println("Hello World!");

        Greeter greeter = new Greeter();
        greeter.greet(anonymousGreeting);
        greeter.greet(lambdaGreeting);
    }
}
