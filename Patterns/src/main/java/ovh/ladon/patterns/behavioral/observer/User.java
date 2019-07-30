package ovh.ladon.patterns.behavioral.observer;

public class User implements UserObserver {
	private String name;

	private int timesWasNotified;

	public User(String name) {
		this.name = name;
		timesWasNotified = 0;
	}

	@Override
	public void update(Product product) {
		sendEmail(product);
	}


	private void sendEmail(Product product) {
		String availibity = product.isInStock()? "in stock" : "no longer available";
		System.out.println("Sending email to " + name + " informing product is " + availibity);
		timesWasNotified++;
	}

	public int getTimesWasNotified() {
		return timesWasNotified;
	}
}
