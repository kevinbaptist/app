package ovh.ladon.threads;

import static org.junit.jupiter.api.Assertions.*;

class DeadLockExampleTest {
	public static void main(String[] args) {
		DeadLockExample business = new DeadLockExample();

		for (int i = 0; i < 100; i++) {
			new Thread(business::foo).start();
			new Thread(business::bar).start();
		}
	}
}
