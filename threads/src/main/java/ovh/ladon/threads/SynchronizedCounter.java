package ovh.ladon.threads;

public class SynchronizedCounter {

	private int counter = 0;

	public void increment() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter++;
		System.out.println("value for " + Thread.currentThread().getName());

	}

	public int getCounter() {
		return counter;
	}
}
