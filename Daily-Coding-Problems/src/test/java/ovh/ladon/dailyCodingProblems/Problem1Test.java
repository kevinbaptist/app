package ovh.ladon.dailyCodingProblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Problem1Test {
	@Test
	void shouldFindSum() {
		int [] listOfNumbers = {10, 15, 3, 7};
		int sum = 17;
		assertTrue(Problem1.isAddUpToK(listOfNumbers, sum));
		assertTrue(Problem1.is(listOfNumbers, sum));
	}

	@Test
	void shouldNotFindSum() {
		int [] listOfNumbers = {10, 15, 3, 7};
		int sum = 19;
		assertFalse(Problem1.isAddUpToK(listOfNumbers, sum));
		assertFalse(Problem1.is(listOfNumbers, sum));
	}
}
