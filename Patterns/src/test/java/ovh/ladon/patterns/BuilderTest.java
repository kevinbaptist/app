package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.creational.builder.implementation.PersonBuilder;
import ovh.ladon.patterns.creational.builder.implementation.PetBuilder;
import ovh.ladon.patterns.models.Person;
import ovh.ladon.patterns.models.Pet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class BuilderTest {
    private String MARY = "Mary";
    private String DEFAULT_NAME = "John";
    private int PERSON_AGE = 25;
    private String PET_1_NAME = "Pet1";
    private String PET_2_NAME = "Pet2";

    @Test
        void givenDefaultName_WhenWeBuildPerson_ThenWeGetDEFAULTName() {
        Person john = new PersonBuilder().build();
        assertEquals(john.getName(), DEFAULT_NAME);
    }

    @Test
    void givenAName_WhenWeBuildPerson_ThenWeGetNewName() {
        Person mary = new PersonBuilder().withName(MARY).build();
        assertEquals(mary.getName(), MARY);
    }

    @Test
    void givenDefaultAge_WhenWeBuildPerson_ThenWeGet65() {
        Person john = new PersonBuilder().build();
        assertEquals(john.getAge(), 65);
    }

    @Test
    void givenAAge_WhenWeBuildPerson_ThenWeGetNewAge() {
        Person john = new PersonBuilder().withAge(PERSON_AGE).build();
        assertEquals(john.getAge(), PERSON_AGE);
    }

    @Test
    void givenDefaultPet_WhenWeBuildPerson_ThenWeGetNoPets() {
        Person person = new PersonBuilder().build();
        assertTrue(person.getPets().isEmpty());
    }

    @Test
    void givenSomePets_WhenWeBuildPerson_ThenWeGetThosePets() {
        Person person = new PersonBuilder()
                .withName(MARY)
                .withPet()
                    .withName(PET_1_NAME)
                .and()
                .withPet()
                    .withName(PET_2_NAME)
                .and()
                .build();
        assertEquals(2, person.getPets().size());

        assertEquals(PET_1_NAME, person.getPets().get(0).getName());
        assertEquals(PET_2_NAME, person.getPets().get(1).getName());
    }

    @Test
    void givenAPet_WhenWeGiveItCookie_ThenNumberIncrease() {
        PersonBuilder personBuilder = new PersonBuilder();
        PetBuilder<PersonBuilder> petBuilder = new PetBuilder<>(personBuilder);
        petBuilder.afterBuild(Pet::eatCooky);
        petBuilder.afterBuild(Pet::eatCooky);
        petBuilder.afterBuild(Pet::eatCooky);

        Person mary = personBuilder
                .withName(MARY)
                .withPet(petBuilder)
                .and()
                .withPet()
                .and()
                .build();

        assertEquals(mary.getName(), MARY);
        assertEquals(3, mary.getPets().get(0).getCookiesEaten());
        assertEquals(0, mary.getPets().get(1).getCookiesEaten());
    }

}