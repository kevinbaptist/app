package ovh.ladon.comparator;

import ovh.ladon.comparable.Person;

import java.util.Comparator;

public class PersonAgeCompareByDesc implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person2.getAge() - person1.getAge();
    }
}
