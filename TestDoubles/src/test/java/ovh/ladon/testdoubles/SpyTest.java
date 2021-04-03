package ovh.ladon.testdoubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest {

	@Test
	void whenGettingSpecialCode_thenAuthorizeIsCalled() {
		AcceptingAuthorizerSpy authorizer = new AcceptingAuthorizerSpy();
		SystemManager systemManager = new SystemManager(authorizer);
		systemManager.getSpecialCode("", "");

		assertTrue(authorizer.wasAuthorizedCalled());

	}
}
