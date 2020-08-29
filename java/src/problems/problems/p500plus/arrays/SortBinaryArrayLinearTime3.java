package problems.p500plus.arrays;

import java.util.Arrays;

/**
 * 
 * The time complexity of above solution is O(n) and auxiliary space used by the
 * program is O(1).
 * 
 * 
 * 
 * We can also solve this problem in linear time by using partitioning logic of
 * quicksort. The idea is to use 1 as pivot element and make one pass of
 * partition process. The resultant array will be sorted.
 * 
 * The time complexity of above solution is O(n) and auxiliary space used by the program is O(1).
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SortBinaryArrayLinearTime3 {
	// Function to sort binary array in linear time
	public static void sort(int[] A) {
		int pivot = 1;
		int j = 0;

		// each time we encounter a 0, j is incremented and
		// 0 is placed before the pivot
		for (int i = 0; i < A.length; i++) {
			if (A[i] < pivot) {
				swap(A, i, j);
				j++;
			}
		}
	}

	// Utility function to swap elements at two indices in the given array
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// Sort binary array in linear time
	public static void main(String[] args) {
		int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

		sort(A);

		// print the rearranged array
		System.out.println(Arrays.toString(A));
	}
}
