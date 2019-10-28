package ovh.ladon.dailyCodingProblems;

import java.util.HashSet;

/***
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Best answer: Second implementation reveal to be best.
 */
class Problem1 {

	/**
	 O(N^2) time and space complexity
	 */
	static boolean isAddUpToK(int[] list, int target) {
		for (int i = 0; i < list.length; i++) {
			for (int j = i; j < list.length; j++) {
				if (list[i] + list[j] == target) {
					return true;
				}
			}
		}
		return false;
	}


	/**
	 *  O(N) time and space complexity
	 *  Implementing hashset instead of ArrayList:
	 		* Array list allows duplicates while, hashset doesn't
	 *  	* for small length list can have a small advantage over set, although in larger length, sets beats list by a lot
	 */
	static boolean is(int[] list, int target) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int value : list) {
			if (hashSet.contains(target - value)) {
				return true;
			}
			hashSet.add(value);
		}
		return false;
	}

}
