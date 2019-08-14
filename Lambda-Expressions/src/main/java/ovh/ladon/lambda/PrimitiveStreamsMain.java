package ovh.ladon.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreamsMain {
	public static void main(String[] args) {
		IntStream.range(1, 4)
				.forEach(System.out::print);

		System.out.println();
		Arrays.stream(new int[]{1, 2, 3, 4})
				.map(n -> n * n)
				.average()
				.ifPresent(System.out::print);

		System.out.println();
		Stream.of(1.4, 2.3, 3.7)
				.mapToInt(Double::intValue)
				.forEach(System.out::print);
	}
}
