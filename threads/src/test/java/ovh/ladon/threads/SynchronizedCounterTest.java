package ovh.ladon.threads;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedCounterTest {


	@Test
	void name() throws InterruptedException {

		SynchronizedCounter synchronizedCounter = new SynchronizedCounter();


		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(synchronizedCounter::increment));
		}
		threads.forEach(Thread::start);
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});


		System.out.println(synchronizedCounter.getCounter());
		assertEquals(10, synchronizedCounter.getCounter());

	}
}
