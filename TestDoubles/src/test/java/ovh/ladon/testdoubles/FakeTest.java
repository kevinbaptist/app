package ovh.ladon.testdoubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FakeTest {

	@Test
	void whenTestingBusinessRules_thenBobMustBeAuthenticatedToMakeItWork() {
		SystemManager systemManager = new SystemManager(new AcceptingAuthorizerFake());
		assertThrows(IllegalArgumentException.class, ()->systemManager.getSpecialCode("", ""));
		assertEquals("SpecialCode", systemManager.getSpecialCode("Bob", "password"));
	}
}
