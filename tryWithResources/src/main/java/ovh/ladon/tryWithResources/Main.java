package ovh.ladon.tryWithResources;

public class Main {


	public static void main(String[] args) throws Exception {
		CustomResource customResource = new CustomResource();
		AnotherClosableResource anotherClosableResource = new AnotherClosableResource();

		try (customResource;anotherClosableResource){//from Java 9 we can use try-with-resources like this
			customResource.error();
			System.out.println("Coding execution");
		} finally {
			System.out.println("Closing always happens, even on exception");
			System.out.println("the closing happens in reverse, that it was inside try!!!!");
		}
	}


}
