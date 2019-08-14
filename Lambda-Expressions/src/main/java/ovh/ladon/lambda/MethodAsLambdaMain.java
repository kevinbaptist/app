package ovh.ladon.lambda;

import java.util.function.IntFunction;

public class MethodAsLambdaMain {
	public static void main(String[] args) {
		IntFunction<String> intToString = num -> Integer.toString(num);
		System.out.println("expected value 3, actual value: " + intToString.apply(123).length());

		//static method reference using ::
		IntFunction<String> intToString2 = Integer::toString;
		System.out.println("expected value 4, actual value:  " + intToString2.apply(4567).length());
	}
}
