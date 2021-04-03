package ovh.ladon.threads;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class SleepMessages implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		SleepMessages sleepMessages = new SleepMessages();
		System.out.println("I've eaten");

	}

	private final List<String> importInfo = List.of("Mares eat oats",
			"Does eat oats",
			"Little lambs eat ivy",
			"A kid will eat ivy too");

	public SleepMessages() {
		Thread thread = new Thread(this);
		thread.start();
//		thread.interrupt();
	}

	@Override
	public void run() {
		Thread.interrupted();
		for (int i = 0; i < importInfo.size(); i++) {
			try {
				Thread.sleep(3000);
				System.out.println(importInfo.get(i));
			} catch (InterruptedException e) {
				System.out.println("Sleep interrupted");
			}
		}
	}
}
