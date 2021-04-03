package ovh.ladon.testdoubles;

/**
 * This is a Dummy.
 * Why? because we return a null
 * why? because we don't care how it is used
 */
public class DummyAuthorizer implements Authorizer {

	@Override
	public Boolean authorize(String username, String password) {
		return null;
	}
}
