package ovh.ladon.threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnotherThreadTest {

	@Test
	void runningBG() {
		AnotherThread anotherThread = new AnotherThread();
		Thread thread = new Thread(anotherThread);

		thread.start();

	}
}
