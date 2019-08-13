package ovh.ladon.patterns.structural.decorator;

public class Notification implements Notifier {
	private String message;

	public Notification(String message) {
		this.message = message;
	}

	@Override
	public void send() {
		System.out.println("Sending notifications");
	}

	@Override
	public String getMessage() {
		return message;
	}
}
