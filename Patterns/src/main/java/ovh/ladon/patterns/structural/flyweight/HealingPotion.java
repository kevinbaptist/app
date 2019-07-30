package ovh.ladon.patterns.structural.flyweight;

/**
 * Contains state unique for each Healing Potion
 */
public class HealingPotion {
  private Potion potion;
  private String name;

  public HealingPotion(Potion potion, String name) {
    this.potion = potion;
    this.name = name;
  }

  public Potion getPotion() {
    return potion;
  }

  public void setPotion(Potion potion) {
    this.potion = potion;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}