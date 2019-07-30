package ovh.ladon.patterns.behavioral.command.implementation;

import ovh.ladon.patterns.behavioral.command.Command;
import ovh.ladon.patterns.models.Target;

abstract class Spell implements Command {
    Target target;
}
