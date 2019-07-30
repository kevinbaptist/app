package ovh.ladon.patterns.creational.builder.implementation;

import ovh.ladon.patterns.creational.builder.Builder;
import ovh.ladon.patterns.models.Person;
import ovh.ladon.patterns.models.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonBuilder extends Builder<Person> {
    private static final String DEFAULT_NAME = "John";
    private static final int DEFAULT_AGE = 65;

    private String name;
    private int age;

    private List<PetBuilder> petBuilders;

    public PersonBuilder() {
        this.name = DEFAULT_NAME;
        this.age = DEFAULT_AGE;
        this.petBuilders = new ArrayList<>();
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public PetBuilder<PersonBuilder> withPet() {
        PetBuilder<PersonBuilder> personBuilderPetBuilder = new PetBuilder<>(this);
        petBuilders.add(personBuilderPetBuilder);
        return personBuilderPetBuilder;
    }

    public PetBuilder<PersonBuilder> withPet(PetBuilder<PersonBuilder> petBuilder) {
        petBuilders.add(petBuilder);
        return petBuilder;
    }


    @Override
    protected Person create() {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        List<Pet> pets = petBuilders.stream().map(PetBuilder<PersonBuilder>::build).collect(Collectors.toList());
        person.setPets(pets);
        return person;
    }

}
