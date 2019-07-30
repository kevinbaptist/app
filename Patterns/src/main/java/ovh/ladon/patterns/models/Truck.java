package ovh.ladon.patterns.models;

public class Truck implements Transport {
    @Override
    public DeliverMethod deliver() {
        return DeliverMethod.BOX;
    }
}
