package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.behavioral.observer.Product;
import ovh.ladon.patterns.behavioral.observer.User;

import static org.junit.Assert.assertEquals;

public class UserObserverTest {

	@Test
	void whenUserSubscribeToService_thenTheyAreNotified() {
		final var john = new User("John");
		final var mary = new User("Mary");
		final var james = new User("James");
		Product product = new Product();

		product.subscribe(john);
		product.subscribe(mary);
		product.subscribe(james);

		product.notifyObservers();

		assertEquals(john.getTimesWasNotified(), 1);
		assertEquals(mary.getTimesWasNotified(), 1);
		assertEquals(james.getTimesWasNotified(), 1);

		product.setInStock(true);
		assertEquals(john.getTimesWasNotified(), 2);
		assertEquals(mary.getTimesWasNotified(), 2);
		assertEquals(james.getTimesWasNotified(), 2);

		product.unsubscribe(mary);
		product.notifyObservers();

		assertEquals(john.getTimesWasNotified(), 3);
		assertEquals(mary.getTimesWasNotified(), 2);
		assertEquals(james.getTimesWasNotified(), 3);

	}
}
