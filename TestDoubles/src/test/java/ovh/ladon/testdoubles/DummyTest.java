package ovh.ladon.testdoubles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DummyTest {

	@Test
	void newlyCreateHouseManager_hasNoHousesCreated() {
		//For this specific situation, has we don't use the builder for anything we should use a dummy which return null
		SystemManager systemManager = new SystemManager(new DummyAuthorizer());

		Assertions.assertEquals(0, systemManager.getNumberOfUsersLoggedIn());
	}
}
