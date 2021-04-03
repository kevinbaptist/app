package ovh.ladon.testdoubles;

/**
 * This is a Spy.
 * Why would I use it? to be sure the authorize was called by your system.
 * So a Spy spies in the caller. I could count number of invocations? yup
 * Is it not coupling? yes, beware of using it. That leads to fragile tests
 * What is a fragile test? A test that breaks for reasons it shouldn't
 *
 */
public class AcceptingAuthorizerSpy implements Authorizer{
	private boolean authorizeWasCalled = false;


	@Override
	public Boolean authorize(String username, String password) {
		authorizeWasCalled = true;
		return true;
	}

	public boolean wasAuthorizedCalled() {
		return authorizeWasCalled;
	}
}
