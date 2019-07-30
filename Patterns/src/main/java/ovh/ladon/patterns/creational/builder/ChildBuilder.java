package ovh.ladon.patterns.creational.builder;

import java.util.Optional;

public abstract class ChildBuilder<T, P extends Builder> extends Builder<T> {
    private final Optional<P> parentBuilder;

    public ChildBuilder() {
        parentBuilder = Optional.empty();
    }

    protected ChildBuilder(P parentBuilder) {
        this.parentBuilder = Optional.of(parentBuilder);
    }

    public P and() {
        return parentBuilder.orElseThrow(() -> new IllegalStateException("A child builder's 'and' operation requires a parent builder"));
    }

    public P requireParent() {
        return parentBuilder.orElseThrow(() -> new IllegalStateException("This operation requires a parent builder"));
    }
}