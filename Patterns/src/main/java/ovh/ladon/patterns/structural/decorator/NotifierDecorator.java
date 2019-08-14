package ovh.ladon.patterns.structural.decorator;

public abstract class NotifierDecorator implements Notifier {
	protected Notifier wrappee;

	NotifierDecorator(Notifier wrappee) {
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
