package ovh.ladon.dailyCodingProblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem2Test {
	@Test
	void checkTransformation() {
		int[] input = new int[]{1, 2, 3, 4, 5};
		int[] expectedOutput = new int[]{120, 60, 40, 30, 24};
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV1(input));
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV2(input));
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV3(input));

		input = new int[]{3, 2, 1};
		expectedOutput = new int[]{2, 3, 6};
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV1(input));
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV2(input));
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV3(input));

		input = new int[]{1};
		expectedOutput = new int[]{0};
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV1(input));
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV2(input));
		assertArrayEquals(expectedOutput, Problem2.getArrayTransformedV3(input));
	}


}
