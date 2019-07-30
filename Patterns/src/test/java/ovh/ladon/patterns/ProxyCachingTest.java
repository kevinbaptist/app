package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.structural.proxy.caching.Image;
import ovh.ladon.patterns.structural.proxy.caching.ProxyImage;

import static org.junit.Assert.assertEquals;

class ProxyCachingTest {

	@Test
	void whenImageExist_thenItReturnCachedImage() {
		Image image = new ProxyImage("abc.jpg");
		assertEquals("Displaying abc.jpg", image.getImage());
	}
}
