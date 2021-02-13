package ovh.ladon.tryWithResources;

public class AnotherClosableResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("Another closable resource");
	}
}
