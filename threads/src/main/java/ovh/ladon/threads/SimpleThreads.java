package ovh.ladon.threads;

public class SimpleThreads {

	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			String[] importantInfo = {
					"Mares eat oats",
					"Does eat oats",
					"Little lambs eat ivy",
					"A kid will eat ivy too"
			};
			try {
				for (String s : importantInfo) {
					Thread.sleep(4000);
					threadMessage(s);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long patience = 3000;

		threadMessage("Starting MessageLoop thread");

		long startTime = System.currentTimeMillis();

		Thread t = new Thread(new MessageLoop());
		t.start();
		threadMessage("Waiting for MessageLoop thread to finish");

		while (t.isAlive()) {
			threadMessage("Still waiting...");
			// Wait maximum of 1 second for MessageLoop thread to finish.
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finally!");
	}
}
