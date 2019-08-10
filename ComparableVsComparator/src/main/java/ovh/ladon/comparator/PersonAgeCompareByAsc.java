package ovh.ladon.comparator;

import ovh.ladon.comparable.Person;

import java.util.Comparator;

public class PersonAgeCompareByAsc implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
