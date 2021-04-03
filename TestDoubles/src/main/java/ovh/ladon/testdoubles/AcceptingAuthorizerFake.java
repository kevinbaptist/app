package ovh.ladon.testdoubles;

/**
 * This is a Fake.
 * It has business behaviour? yes.
 */
public class AcceptingAuthorizerFake implements Authorizer {
	@Override
	public Boolean authorize(String username, String password) {
		return "Bob".equals(username) && "password".equals(password);
	}
}
