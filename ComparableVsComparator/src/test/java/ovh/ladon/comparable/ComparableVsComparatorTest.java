package ovh.ladon.comparable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ovh.ladon.comparator.PersonAgeCompareByAsc;
import ovh.ladon.comparator.PersonAgeCompareByDesc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparableVsComparatorTest {
    private List<Person> peoples;

    @BeforeEach
    void setUp() {
        peoples = new ArrayList<>();
        peoples.add(new Person("John", "Edward", 23));
        peoples.add(new Person("Jame", "Mccullough", 24));
        peoples.add(new Person("Anne", "Pratt", 22));
        peoples.add(new Person("Liam", "Smith", 18));
        peoples.add(new Person("Lewis", "Wood", 22));
        peoples.add(new Person("Nathalie", "Bird", 50));
        peoples.add(new Person("Kailey", "Stone", 15));
        peoples.add(new Person("Billy", "Rocha", 19));
        peoples.add(new Person("Corinne", "Arellano", 80));
    }

    @Test
    void usingComparable() {
        System.out.println("Sorted list as they were inserted");
        peoples.forEach(System.out::println);
        Collections.sort(peoples);
        System.out.println("\nSorted list by age asc");
        peoples.forEach(System.out::println);
    }

    @Test
    void usingComparator() {
        System.out.println("Sorted list as they were inserted");
        peoples.forEach(System.out::println);

        System.out.println("\nSorted list by age asc");
        peoples.stream()
                .sorted(new PersonAgeCompareByAsc())
                .forEach(System.out::println);

        System.out.println("\nSorted list by age desc");
        peoples.stream()
                .sorted(new PersonAgeCompareByDesc())
                .forEach(System.out::println);
    }
}