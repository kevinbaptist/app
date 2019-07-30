package ovh.ladon.patterns.behavioral.command;

import ovh.ladon.patterns.models.Target;

public interface Command {
    void execute(Target target);
    void undo();
    void redo();
}