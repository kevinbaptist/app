package ovh.ladon.patterns.creational.builder.implementation;

import ovh.ladon.patterns.creational.builder.Builder;
import ovh.ladon.patterns.creational.builder.ChildBuilder;
import ovh.ladon.patterns.models.Pet;

public class PetBuilder<T extends Builder> extends ChildBuilder<Pet, T> {

    private String name;

    public PetBuilder(T parentBuilder) {
        super(parentBuilder);
    }

    public PetBuilder<T> withName(String name){
        this.name = name;
        return this;
    }

    @Override
    protected Pet create() {
        return new Pet(name);
    }

}
