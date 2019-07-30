package ovh.ladon.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.behavioral.command.implementation.InvisibleSpell;
import ovh.ladon.patterns.behavioral.command.implementation.ShrinkSpell;
import ovh.ladon.patterns.models.Size;
import ovh.ladon.patterns.models.Target;
import ovh.ladon.patterns.models.Visibility;
import ovh.ladon.patterns.models.Wizard;

import static org.junit.Assert.assertEquals;

public class CommandTest {
    private Wizard wizard;
    @BeforeEach
    void setUp() {
        wizard = new Wizard();

    }

    @Test
    void castSpells() {
        Target target = new Target(Size.LARGE, Visibility.VISIBLE);
        assertEquals(target.getSize(), Size.LARGE);

        wizard.castSpell(new ShrinkSpell(), target);
        assertEquals(target.getSize(), Size.SMALL);

        wizard.undoLastSpell();
        assertEquals(target.getSize(), Size.LARGE);

        wizard.castSpell(new ShrinkSpell(), target);
        wizard.castSpell(new InvisibleSpell(), target);
        assertEquals(target.getVisibility(), Visibility.INVISIBLE);
        assertEquals(target.getSize(), Size.SMALL);

        wizard.undoLastSpell();
        assertEquals(target.getVisibility(), Visibility.VISIBLE);
        assertEquals(target.getSize(), Size.SMALL);

        wizard.undoLastSpell();
        assertEquals(target.getVisibility(), Visibility.VISIBLE);
        assertEquals(target.getSize(), Size.LARGE);
    }
}
