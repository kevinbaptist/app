package ovh.ladon.patterns.structural.flyweight;

import java.awt.*;

/**
 * Contains state shared by several Potions*/
public class Potion {
    private Color color;

    public Potion(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
