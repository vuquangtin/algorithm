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
public class SortBinaryArrayLinearTime2 {
	// Function to sort binary array in linear time
	public static void sort(int[] A) {
		// count number of 0's
		int zeros = 0;
		for (int value : A) {
			if (value == 0) {
				zeros++;
			}
		}

		// put 0's in the beginning
		int k = 0;
		while (zeros-- != 0) {
			A[k++] = 0;
		}

		// fill all remaining elements by 1
		while (k < A.length) {
			A[k++] = 1;
		}
	}

	/*-
	 * Sort Binary Array in Linear Time
	 Given a binary array, sort it in linear time and constant space. Output should print contain all zeroes followed by all ones.


	

	 For example,


	 Input: { 1, 0, 1, 0, 1, 0, 0, 1 }
	
	 Output:{ 0, 0, 0, 0, 1, 1, 1, 1 }

	

	 Simple solution would be to count number of 0’s present in the array (say k) and fill first k indices 
	 in the array by 0 and all remaining indices by 1.

	 Alternatively, we can also count number of 1’s present in the array (say k) and fill last k indices
	  in the array by 1 and all remaining indices by 0.
	 */
	// Sort binary array in linear time
	public static void main(String[] args) {
		int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

		sort(A);

		// print the rearranged array
		System.out.println(Arrays.toString(A));
	}
}
