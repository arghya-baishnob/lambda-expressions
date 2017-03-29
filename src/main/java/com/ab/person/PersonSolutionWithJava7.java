package com.ab.person;

import com.ab.person.model.Condition;
import com.ab.person.model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonSolutionWithJava7 {
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Carrol", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person("Charlotte", "Bronte", 45),
            new Person("Matthew", "Arnold", 39)
        );

        // Step 1 : Sort list by last name
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        // Step 2 : Print all persons in the list
        System.out.println("\n" + "Print all persons in the list :");
        printConditionally(persons, new Condition() {
            @Override
            public boolean test(Person person) {
                return true;
            }
        });

        // Step 3 : Print all persons that have first name begin with C
        System.out.println("\n" + "Print all persons that have first name begin with C :");
        printConditionally(persons, new Condition() {
            @Override
            public boolean test(Person person) {
                return person.getFirstName().startsWith("C");
            }
        });

        // Step 4 : Print all persons that have last name begin with C
        System.out.println("\n" + "Print all persons that have last name begin with C :");
        printConditionally(persons, new Condition() {
            @Override
            public boolean test(Person person) {
                return person.getLastName().startsWith("C");
            }
        });
    }

    private static void printConditionally(List<Person> persons, Condition condition) {
        for (Person person : persons) {
            if (condition.test(person)) {
                System.out.println(person);
            }
        }
    }
}