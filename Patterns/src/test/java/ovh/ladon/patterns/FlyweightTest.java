package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.structural.flyweight.HealingPotion;
import ovh.ladon.patterns.structural.flyweight.PotionFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ovh.ladon.patterns.structural.flyweight.PotionType.HEALING_HP;

public class FlyweightTest {

    @Test
    void givenTwoHealingHPPotion_thenCommomAttributeHaveSameReference() {
        PotionFactory potionFactory = new PotionFactory();
        HealingPotion smallHP = new HealingPotion(potionFactory.createPotion(HEALING_HP), "Small");
        HealingPotion mediumHP = new HealingPotion(potionFactory.createPotion(HEALING_HP), "Medium");

        assertEquals(smallHP.getPotion(), mediumHP.getPotion());
        assertEquals(smallHP.getPotion().getColor(), mediumHP.getPotion().getColor());
        assertNotEquals(smallHP.getName(), mediumHP.getName());
    }
}
