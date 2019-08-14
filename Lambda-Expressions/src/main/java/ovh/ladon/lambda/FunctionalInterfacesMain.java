package ovh.ladon.lambda;

import java.util.function.*;

public class FunctionalInterfacesMain {
	public static void main(String[] args) {
		//Predicate accepts one argument and return a boolean
		Predicate<String> stringLen  = (s)-> s.length() < 10;
		System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

		//Consumer: accepts one argument and don't return anything
		Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
		consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

		//Function example
		Function<Integer,String> converter = (num)-> Integer.toString(num);
		System.out.println("length of 26: " + converter.apply(26).length());

		//Supplier example
		Supplier<String> s  = ()-> "Java is fun";
		System.out.println(s.get());

		//Binary Operator example
		BinaryOperator<Integer> add = (a, b) -> a + b;
		System.out.println("add 10 + 25: " + add.apply(10, 25));

		//Unary Operator example
		UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
		System.out.println(str.apply("This is my message in upper case"));
	}
}
