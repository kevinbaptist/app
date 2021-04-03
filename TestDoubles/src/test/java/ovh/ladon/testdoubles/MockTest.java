package ovh.ladon.testdoubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest {

	@Test
	void whenGettingSpecialCode_thenAuthorizeIsCalled() {
		AcceptingAuthorizerVerificationMock authorizer = new AcceptingAuthorizerVerificationMock();
		SystemManager systemManager = new SystemManager(authorizer);
		systemManager.getSpecialCode("", "");

		assertTrue(authorizer.verify());

	}
}
