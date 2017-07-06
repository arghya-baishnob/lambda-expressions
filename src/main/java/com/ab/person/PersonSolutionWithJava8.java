package com.ab.person;

import com.ab.person.model.Condition;
import com.ab.person.model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonSolutionWithJava8 {
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Step 1 : Sort list by last name
        Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2 : Print all persons in the list
        System.out.println("\n" + "Print all persons in the list :");
        performConditionally(persons, p -> true, p -> System.out.println(p.getFirstName() + " " + p.getLastName() + ", Age: " + p.getAge()));

        // Step 3 : Print all persons that have first name begin with C
        System.out.println("\n" + "Print all persons that have first name begin with C :");
        printConditionallyV2(persons, p -> p.getFirstName().startsWith("C"));

        // Step 4 : Print all persons that have last name begin with C
        System.out.println("\n" + "Print all persons that have last name begin with C :");
        printConditionallyV2(persons, p -> p.getLastName().startsWith("C"));
    }

    /**
     * This has two lambda expressions which is
     * mapped to existing java.util.function interface.
     * @param persons
     * @param predicate
     * @param consumer
     */
    private static void performConditionally(List<Person> persons, Predicate<Person> predicate,
                                             Consumer<Person> consumer) {
        for (Person person : persons) {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        }
    }

    /**
     * Using java.util.function interface.
     * @param persons
     * @param predicate
     */
    private static void printConditionallyV2(List<Person> persons, Predicate<Person> predicate) {
        for (Person person : persons) {
            if (predicate.test(person)) {
                System.out.println(person);
            }
        }
    }

    /**
     * This is the old way to assign lamda function to
     * an User defined Interface.
     * @param persons
     * @param condition
     */
    private static void printConditionallyV1(List<Person> persons, Condition condition) {
        for (Person person : persons) {
            if (condition.test(person)) {
                System.out.println(person);
            }
        }
    }
}