package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.structural.proxy.protection.PrisonBuildingProxy;
import ovh.ladon.patterns.structural.proxy.protection.SmallPrison;
import ovh.ladon.patterns.structural.proxy.protection.Thief;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProxyProtectionTest {

	@Test
	void given3Prisioners_whenANewTryToEnter_thenItGetsDenied() {
		Thief a = new Thief("a");
		Thief b = new Thief("b");
		Thief c = new Thief("c");
		Thief d = new Thief("d");
		PrisonBuildingProxy prisonBuildingProxy = new PrisonBuildingProxy(new SmallPrison());

		prisonBuildingProxy.enter(a);
		prisonBuildingProxy.enter(b);
		prisonBuildingProxy.enter(c);

		assertThrows(IllegalArgumentException.class, () -> prisonBuildingProxy.enter(d));
	}
}
