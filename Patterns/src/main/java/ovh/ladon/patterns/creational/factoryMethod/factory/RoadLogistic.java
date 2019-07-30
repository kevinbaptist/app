package ovh.ladon.patterns.creational.factoryMethod.factory;

import ovh.ladon.patterns.models.Transport;
import ovh.ladon.patterns.models.Truck;

public class RoadLogistic implements Logistic {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
