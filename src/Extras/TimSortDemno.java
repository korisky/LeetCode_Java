package Extras;

import java.util.Arrays;

public class TimSortDemno {

    public static void main(String[] args) {

        // Create an array of Person objects
        Person[] people = {
                new Person("Alice", 34),
                new Person("Bob", 24),
                new Person("Charlie", 29),
                new Person("David", 19)
        };

        // Sort the array using TimSort (implicitly)
        // Only when you are not dealing with native types, the one
        // implement the Comparable would call ComparableTimSort
        Arrays.sort(people);

        // Print out the sorted array
        for (Person person : people) {
            System.out.println(person);
        }
    }

    /**
     * Followed https://www.youtube.com/watch?v=GhP5WbE4GYo to implement TimSort
     */
    public record TheTimSort<T extends Comparable<T>>(T[] arr) {

        private static final int MIN_RUN_SIZE = 4;

        public void sort() {

            // 1. sort each run with Insertion Sort
            for (int start = 0; start < arr.length; start += MIN_RUN_SIZE) {
                // in case remaining < min_run_size
                int end = Math.min((start + MIN_RUN_SIZE), (arr.length));
                new InsertionSort<>(arr).sort(start, end);
            }

            // 2. Merge the sorted runs
//            int runSize = 1;
//
//            for (int left = 0; left < arr.length; left += 2 * runSize) {
//                int mid = left + runSize - 1;
//                int right = Math.min((left + 2 * runSize - 1), (arr.length - 1));
//                if (mid < right) {
//                    MergeSort.MergeOne(arr, left, mid, right);
//                }
//            }


        }


    }


    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        // Constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Getter for age
        public int getAge() {
            return age;
        }

        // Implement the compareTo method to define the natural order
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }

        // Override toString to print the person's details
        @Override
        public String toString() {
            return name + ": " + age;
        }
    }


}
