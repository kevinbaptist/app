package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.structural.decorator.EmailDecorator;
import ovh.ladon.patterns.structural.decorator.Notification;
import ovh.ladon.patterns.structural.decorator.NotifierDecorator;
import ovh.ladon.patterns.structural.decorator.SmsDecorator;

class DecoratorTest {
	private static final String MESSAGE = "Hello world!";
	@Test
	void emailAndSmsSent() {
		final Notification notification = new Notification(MESSAGE);
		final EmailDecorator emailDecorator = new EmailDecorator(notification);
		final SmsDecorator smsDecorator = new SmsDecorator(emailDecorator);

		final NotifierDecorator notifierDecorator = new NotifierDecorator(smsDecorator);

		notifierDecorator.send();//an email and sms was sent

	}

	@Test
	void smsSent() {
		final Notification notification = new Notification(MESSAGE);
		final SmsDecorator smsDecorator = new SmsDecorator(notification);

		final NotifierDecorator notifierDecorator = new NotifierDecorator(smsDecorator);

		notifierDecorator.send();//a sms was sent

	}

	@Test
	void emailSent() {
		final Notification notification = new Notification(MESSAGE);
		final EmailDecorator emailDecorator = new EmailDecorator(notification);

		final NotifierDecorator notifierDecorator = new NotifierDecorator(emailDecorator);

		notifierDecorator.send();//an emailwas sent

	}
}
