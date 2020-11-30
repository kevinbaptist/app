package ovh.ladon.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.creational.factoryKit.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactoryKitTest {
	private WeaponFactory factory;

	@BeforeEach
	public void init() {
		factory = WeaponFactory.factory(builder -> {
			builder.add(WeaponType.BOW, Bow::new);
			builder.add(WeaponType.AXE, Axe::new);
		});
	}

	@Test
	public void testAxeWeapon() {
		var weapon = factory.create(WeaponType.AXE);
		verifyWeapon(weapon, Axe.class);
	}
	

	@Test
	public void testBowWeapon() {
		var weapon = factory.create(WeaponType.SWORD);
		verifyWeapon(weapon, Bow.class);
	}

	private void verifyWeapon(Weapon weapon, Class<?> clazz) {
		assertTrue(clazz.isInstance(weapon), "Weapon must be an object of: " + clazz.getName());
	}
}
