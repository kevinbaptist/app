package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.models.RoundHole;
import ovh.ladon.patterns.models.RoundObject;
import ovh.ladon.patterns.models.SquareObject;
import ovh.ladon.patterns.structural.adapter.SquareObjectAdapter;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

class AdapterTest {

    @Test
    void givenARoundObject_WhenWePutItOnRoundHole_ThenItWorks() {
        RoundHole roundHole = new RoundHole(5);
        RoundObject smallRoundObject = new RoundObject(5);
        RoundObject largeRoundObject = new RoundObject(20);

        assertTrue(roundHole.fits(smallRoundObject));
        assertFalse(roundHole.fits(largeRoundObject));
    }

    @Test
    void givenASquareObject_WhenWePutItOnRoundHole_ThenItWorks() {
        RoundHole roundHole = new RoundHole(5);

        SquareObject smallSquare = new SquareObject(2);
        SquareObject largeSquare = new SquareObject(20);

        assertTrue(roundHole.fits(new SquareObjectAdapter(smallSquare)));
        assertFalse(roundHole.fits(new SquareObjectAdapter(largeSquare)));
    }
}
