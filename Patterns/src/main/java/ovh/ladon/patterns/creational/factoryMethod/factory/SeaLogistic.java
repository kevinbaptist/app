package ovh.ladon.patterns.creational.factoryMethod.factory;

import ovh.ladon.patterns.models.Ship;
import ovh.ladon.patterns.models.Transport;

public class SeaLogistic implements Logistic {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
