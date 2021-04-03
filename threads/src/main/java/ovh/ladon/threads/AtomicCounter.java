package ovh.ladon.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	private final AtomicInteger counter;

	public AtomicCounter() {
		this.counter = new AtomicInteger(0);
	}

	public void increment() {
		while (true) {
			int existingValue = getValue();
			int newValue = existingValue + 1;

			if (counter.compareAndSet(existingValue, newValue)) {
				return;
			}
		}
	}

	public int getValue() {
		return this.counter.get();
	}
}
