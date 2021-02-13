package ovh.ladon.tryWithResources;

public class CustomResource implements AutoCloseable {


	public void error() {
		throw new IllegalArgumentException("custom error");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closed my custom resource");
	}
}
