package ovh.ladon.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;


public abstract class Builder<T> {

    private T result;
    private Collection<Consumer<T>> consumers = new ArrayList<>();

    protected abstract T create();

    /**
     * This is used to build the object
     *
     * @return object created
     * @throws IllegalStateException if object was already built
     */
    public T build() {
        if (result != null) {
            throw new IllegalStateException("A builder can only build one object, use a different builder to build different objects");
        }
        result = create();
        consumers.forEach(consumer -> consumer.accept(result));
        return result;
    }

    public void afterBuild(Consumer<T> consumer) {
        if (result == null) {
            consumers.add(consumer);
        } else {
            consumer.accept(result);
        }
    }
}
