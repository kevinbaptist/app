package ovh.ladon.patterns.models;

import ovh.ladon.patterns.behavioral.command.Command;

import java.util.Stack;

public class Wizard {
    private Stack<Command> commands;

    public Wizard() {
        this.commands = new Stack<>();
    }

    public void castSpell(Command command, Target target) {
        command.execute(target);
        commands.push(command);
    }

    public void undoLastSpell() {
        if (!commands.isEmpty()) {
            commands.pop().undo();
        }
    }
}
