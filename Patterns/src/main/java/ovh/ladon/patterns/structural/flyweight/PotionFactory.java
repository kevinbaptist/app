package ovh.ladon.patterns.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates the complexity of flyweight creation
 */
public class PotionFactory {

	private final Map<PotionType, Potion> potions;

	public PotionFactory() {
		potions = new HashMap<>();
	}

	public Potion createPotion(PotionType type) {
		Potion potion = potions.get(type);
		if (potion == null) {
			switch (type) {
				case HEALING_HP:
					potion = new Potion(Color.GREEN);
					break;
				case HEALING_SP:
					potion = new Potion(Color.BLUE);
					break;
				case HEALING_ST:
					potion = new Potion(Color.GRAY);
					break;
				default:
					throw new IllegalArgumentException();
			}
			potions.put(type, potion);
		}
		return potion;
	}
}