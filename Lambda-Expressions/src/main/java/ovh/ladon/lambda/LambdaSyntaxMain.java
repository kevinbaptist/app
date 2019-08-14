package ovh.ladon.lambda;

import java.util.List;
import java.util.function.Consumer;

public class LambdaSyntaxMain {
	public static void main(String[] args) {

		Consumer<String> hello = name -> System.out.println("Hello, " + name);
		List<String> people = List.of("A", "B", "C", "D");
		people.forEach(hello);

		GreetingFunction hi = name -> System.out.println("Hi, " + name);
		people.forEach(hi::sayHi);

	}

	@FunctionalInterface
	interface GreetingFunction{
		void sayHi(String person);
	}

}
