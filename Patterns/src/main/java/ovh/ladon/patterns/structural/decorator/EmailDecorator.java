package ovh.ladon.patterns.structural.decorator;

public class EmailDecorator extends NotifierDecorator{
	public EmailDecorator(Notifier wrappee) {
		super(wrappee);
	}

	@Override
	public void send() {
		super.send();
		System.out.println("An email was sent: " + wrappee.getMessage());
	}
}
