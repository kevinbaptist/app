package ovh.ladon.testdoubles;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	private final Authorizer authorizer;
	private final List<String> usersLoggedIn;

	public SystemManager(Authorizer authorizer) {
		this.authorizer = authorizer;
		usersLoggedIn = new ArrayList<>();
	}

	public int getNumberOfUsersLoggedIn() {
		return usersLoggedIn.size();
	}

	public String getSpecialCode(String username, String password) {
		if (!this.authorizer.authorize(username, password)) {
			throw new IllegalArgumentException("You are not logged in");
		}

		return "SpecialCode";
	}
}
