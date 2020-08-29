package problems.p500plus.arrays;

import java.util.Arrays;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SortBinaryArrayLinearTime {
	// Function to sort binary array in linear time
	public static void sort(int[] A) {
		// k stores index of next available position
		int k = 0;

		// do for each element
		for (int i : A) {
			// if current element is zero, put 0 at next free
			// position in the array
			if (i == 0) {
				A[k++] = 0;
			}
		}

		// fill all remaining indices by 1
		for (int i = k; i < A.length; i++) {
			A[k++] = 1;
		}
	}

	/*-
	 * The time complexity of above solution is O(n) and auxiliary space used by the program is O(1).

	

	Instead of counting number of zeroes, if the current element is 0, we can place 0 at 
	next available position in the array. 
	After all elements in the array are processed, we fill all remaining indices by 1.
	 */
	// Sort binary array in linear time
	public static void main(String[] args) {
		int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

		sort(A);

		// print the rearranged array
		System.out.println(Arrays.toString(A));
	}
}
