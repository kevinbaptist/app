package ovh.ladon.patterns.models;

public class Pet {
    private String name;
    private int cookiesEaten;

    public Pet(String name) {
        this.name = name;
        cookiesEaten = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eatCooky() {
        cookiesEaten++;
    }

    public int getCookiesEaten() {
        return cookiesEaten;
    }
}
