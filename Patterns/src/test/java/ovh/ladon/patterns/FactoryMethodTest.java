package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.creational.factoryMethod.factory.Logistic;
import ovh.ladon.patterns.creational.factoryMethod.factory.RoadLogistic;
import ovh.ladon.patterns.creational.factoryMethod.factory.SeaLogistic;
import ovh.ladon.patterns.models.DeliverMethod;
import ovh.ladon.patterns.models.Ship;
import ovh.ladon.patterns.models.Transport;
import ovh.ladon.patterns.models.Truck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryMethodTest {
    @Test
    void testRoadLogistic() {
        Logistic logistic= new RoadLogistic();
        Transport transport = logistic.createTransport();
        assertTrue(transport instanceof Truck);
        assertEquals(transport.deliver(), DeliverMethod.BOX);
    }

    @Test
    void test() {
        Logistic logistic= new SeaLogistic();
        Transport transport = logistic.createTransport();
        assertTrue(transport instanceof Ship);
        assertEquals(transport.deliver(), DeliverMethod.CONTAINER);
    }

}
