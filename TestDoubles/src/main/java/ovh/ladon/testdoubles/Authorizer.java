package ovh.ladon.testdoubles;

public interface Authorizer {
	Boolean authorize(String username, String password);
}
