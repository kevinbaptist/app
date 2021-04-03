package ovh.ladon.testdoubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StubTest {

	@Test
	void gettingSpecialCode_thenReturnsSpecialCode() {
		SystemManager systemManager = new SystemManager(new AcceptingAuthorizedStub());

		String specialCode = systemManager.getSpecialCode("", "");
		assertEquals("SpecialCode", specialCode);
	}
}
