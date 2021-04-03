package ovh.ladon.testdoubles;

/**
 * This a Stub
 * Why? It returns true
 * Why? I suppose you want to test a part of your system that requires to be logged in
 * Why not log in? because you already know it works and it's slow
 */
public class AcceptingAuthorizedStub implements Authorizer {

	@Override
	public Boolean authorize(String username, String password) {
		return true;
	}
}
