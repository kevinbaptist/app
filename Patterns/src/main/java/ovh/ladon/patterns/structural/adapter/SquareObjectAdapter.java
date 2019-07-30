package ovh.ladon.patterns.structural.adapter;

import ovh.ladon.patterns.models.RoundObject;
import ovh.ladon.patterns.models.SquareObject;

public class SquareObjectAdapter extends RoundObject {
    private SquareObject squareObject;

    public SquareObjectAdapter(SquareObject squareObject) {
        this.squareObject = squareObject;
    }

    @Override
    public double getRadius() {
        // Calculate a minimum circle radius, which can fit this peg.
        return (Math.sqrt(Math.pow((squareObject.getWidth() / 2), 2) * 2));
    }
}
