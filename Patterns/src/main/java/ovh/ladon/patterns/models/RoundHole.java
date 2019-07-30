package ovh.ladon.patterns.models;

/**
 * RoundHoles are only compatible with RoundObjects.
 */
public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundObject roundObject) {
        return this.getRadius() >= roundObject.getRadius();
    }

}
