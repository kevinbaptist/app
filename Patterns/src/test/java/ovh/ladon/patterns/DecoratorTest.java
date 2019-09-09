package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.structural.decorator.*;

class DecoratorTest {
	private static final String MESSAGE = "Hello world!";
	@Test
	void emailAndSmsSent() {
		Notifier notification = new Notification(MESSAGE);
		notification = new EmailDecorator(notification);
		notification = new SmsDecorator(notification);

		notification.send();//an email and sms was sent

	}

	@Test
	void smsSent() {
		Notifier notification = new Notification(MESSAGE);
		notification = new SmsDecorator(notification);

		notification.send();//a sms was sent

	}

	@Test
	void emailSent() {
		final Notification notification = new Notification(MESSAGE);
		final EmailDecorator emailDecorator = new EmailDecorator(notification);

		final NotifierDecorator notifierDecorator = new EmailDecorator(emailDecorator);

		notifierDecorator.send();//an emailwas sent

	}
}
