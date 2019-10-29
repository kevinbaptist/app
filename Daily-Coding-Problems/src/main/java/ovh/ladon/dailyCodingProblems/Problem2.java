package ovh.ladon.dailyCodingProblems;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of
 * all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
class Problem2 {

	static int[] getArrayTransformedV1(int[] array) {
		int[] arrayTransformed = new int[array.length];
		if (array.length == 1) {
			arrayTransformed[0] = 0;
			return arrayTransformed;
		}
		int total = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j) {
					total = total * array[j];
				}
			}
			arrayTransformed[i] = total;
			total = 1;
		}
		return arrayTransformed;
	}

	static int[] getArrayTransformedV2(int[] array) {
		int[] arrayTransformed = new int[array.length]; // This is the result
		if (array.length == 1) {
			arrayTransformed[0] = 0;
			return arrayTransformed;
		}
		int[] products_below = new int[array.length];
		int total = 1;
		for (int i = 0; i < array.length; i++) {
			products_below[i] = total;
			total *= array[i];
		}

		int[] products_above = new int[array.length];
		total = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			products_above[i] = total;
			total *= array[i];
		}


		for (int i = 0; i < array.length; ++i) {
			arrayTransformed[i] = products_below[i] * products_above[i];
		}
		return arrayTransformed;
	}

	static int[] getArrayTransformedV3(int[] array) {
		int[] arrayTransformed = new int[array.length]; // This is the result
		if (array.length == 1) {
			arrayTransformed[0] = 0;
			return arrayTransformed;
		}
		// Get the products below the current index
		int total = 1;
		for (int i = 0; i < array.length; i++) {
			arrayTransformed[i] = total;
			total *= array[i];
		}

		// Get the arrayTransformed above the curent index
		total = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			arrayTransformed[i] *= total;
			total *= array[i];
		}
		return arrayTransformed;
	}


}
