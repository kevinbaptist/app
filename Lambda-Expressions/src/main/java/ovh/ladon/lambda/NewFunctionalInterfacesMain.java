package ovh.ladon.lambda;

public class NewFunctionalInterfacesMain {
	public static void main(String[] args) {
		Calculate add = (a, b) -> a + b;
		Calculate difference = (a, b) -> Math.abs(a-b);
		Calculate divide = (a, b) -> (b != 0 ? a/b : 0);

		System.out.println(add.calc(2, 3));
		System.out.println(difference.calc(5, 11));
		System.out.println(divide.calc(20, 2));



		//Functional interface using generics
		GenericCalculate<Double> doubleAdd = (a, b) -> a + b;
		GenericCalculate<Double> doubleDifference = (a, b) -> Math.abs(a-b);
		GenericCalculate<Double> doubleDivide = (a, b) -> (b != 0 ? a/b : 0);

		System.out.println(doubleAdd.calc(2.2, 3.5));
		System.out.println(doubleDifference.calc(5.0, 11.1));
		System.out.println(doubleDivide.calc(20.0, 2.5));
	}
}
