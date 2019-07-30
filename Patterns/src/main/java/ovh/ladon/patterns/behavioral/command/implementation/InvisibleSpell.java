package ovh.ladon.patterns.behavioral.command.implementation;

import ovh.ladon.patterns.models.Target;
import ovh.ladon.patterns.models.Visibility;

public class InvisibleSpell extends Spell {
    private Visibility oldVisibility;



    @Override
    public void execute(Target target) {
        oldVisibility = target.getVisibility();
        target.setVisibility(Visibility.INVISIBLE);
        this.target = target;
    }

    @Override
    public void undo() {
        if (target != null && oldVisibility != null) {
            target.setVisibility(oldVisibility);
            oldVisibility = null;
        }
    }

    @Override
    public void redo() {

    }
}
