package ovh.ladon.patterns.structural.decorator;

public class SmsDecorator extends NotifierDecorator{
	public SmsDecorator(Notifier wrappee) {
		super(wrappee);
	}

	@Override
	public void send() {
		super.send();
		System.out.println("A sms was sent: " + wrappee.getMessage());
	}
}
