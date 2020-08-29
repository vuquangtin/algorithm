package problems.p500plus.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class FindSubArrayWith0Sum2 {
	// Utility function to insert <key, value> into the Multimap
	private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
		// if the key is seen for the first time, initialize the list
		if (!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}

		hashMap.get(key).add(value);
	}

	// Function to print all sub-arrays with 0 sum present
	// in the given array
	public static void printallSubarrays(int[] A) {
		// create an empty Multi-map to store ending index of all
		// sub-arrays having same sum
		Map<Integer, List<Integer>> hashMap = new HashMap<>();

		// insert (0, -1) pair into the map to handle the case when
		// sub-array with 0 sum starts from index 0
		insert(hashMap, 0, -1);

		int sum = 0;

		// traverse the given array
		for (int i = 0; i < A.length; i++) {
			// sum of elements so far
			sum += A[i];

			// if sum is seen before, there exists at-least one
			// sub-array with 0 sum
			if (hashMap.containsKey(sum)) {
				List<Integer> list = hashMap.get(sum);

				// find all sub-arrays with same sum
				for (Integer value : list) {
					System.out.println("Subarray [" + (value + 1) + ".." + i
							+ "]");
				}

			}

			// insert (sum so far, current index) pair into the Multi-map
			insert(hashMap, sum, i);
		}
	}

	/*-
	 * Approach 2: Using multimap to print all subarrays
	

	 We can use MultiMap to print all sub-arrays with 0 sum present in the given array. 
	 The idea is to create an empty multimap to store ending index of all sub-arrays having given sum.
	  We traverse the given array, and maintain sum of elements seen so far. 
	  If sum is seen before, there exists at-least one sub-array with 0 sum which ends at current index and we print all such sub-arrays.
	 */
	public static void main(String[] args) {
		int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

		printallSubarrays(A);
	}
}
