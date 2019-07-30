package ovh.ladon.patterns.behavioral.command.implementation;

import ovh.ladon.patterns.models.Size;
import ovh.ladon.patterns.models.Target;

public class ShrinkSpell extends Spell{
    private Size oldSize;


    @Override
    public void execute(Target target) {
        oldSize = target.getSize();
        target.setSize(Size.SMALL);
        this.target = target;
    }

    @Override
    public void undo() {
        if (target != null && oldSize != null) {
            target.setSize(oldSize);
            oldSize = null;
        }
    }

    @Override
    public void redo() {

    }
}
