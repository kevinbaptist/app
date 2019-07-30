package ovh.ladon.patterns.models;

public class Ship implements Transport {
    @Override
    public DeliverMethod deliver() {
        return DeliverMethod.CONTAINER;
    }
}
