package ovh.ladon.threads;

public class AnotherThread implements Runnable {
	@Override
	public void run() {
		System.out.println("Running in BG");
	}
}
