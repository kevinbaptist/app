package ovh.ladon.patterns.structural.decorator;

public class NotifierDecorator implements Notifier {
	protected Notifier wrappee;

	public NotifierDecorator(Notifier wrappee) {
		this.wrappee = wrappee;
	}

	@Override
	public void send() {
		wrappee.send();
	}

	@Override
	public String getMessage() {
		return wrappee.getMessage();
	}
}
