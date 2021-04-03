package ovh.ladon.testdoubles;

/**
 * This a mock. A true Mock :)
 * So you just put the assertion into the mock? Not quite, what we're testing is behaviour
 * Behaviour? Yes, a mock is more interested in what function were called, with what arguments, when and how often.
 * That's not a spy? Yes, a mock spies on the behaviour and knows what to expect
 */
public class AcceptingAuthorizerVerificationMock implements Authorizer {
	public boolean authorizeWasCalled = false;

	public Boolean authorize(String username, String password) {
		authorizeWasCalled = true;
		return true;
	}

	public boolean verify() {
		return authorizeWasCalled;
	}
}
