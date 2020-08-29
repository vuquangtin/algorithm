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
public class FindSubArrayWith0Sum {
	// Function to print all sub-arrays with 0 sum present
	// in the given array
	public static void printallSubarrays(int[] A) {

		// consider all sub-arrays starting from i
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			int[] B = new int[A.length];
			// consider all sub-arrays ending at j
			for (int j = i; j < A.length; j++) {
				// sum of elements so far
				sum += A[j];
				B[j] = A[j];
				// if sum is seen before, we have found a subarray with 0 sum
				if (sum == 0) {
					//System.out.println("Subarray [" + i + ".." + j + "]");
					System.out.println(Arrays.toString(B));
				}
			}
		}
	}

	/*-
	 * Print all sub-arrays with 0 sum
	 Given an array of integers, print all sub-arrays with 0 sum.


	

	 For example,

	 Input:  { 4, 2, -3, -1, 0, 4 }
	
	 Sub-arrays with 0 sum are
	
	 { -3, -1, 0, 4 }
	 { 0 }
	
	
	 Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
	
	 Sub-arrays with 0 sum are
	
	 { 3, 4, -7 }
	 { 4, -7, 3 }
	 { -7, 3, 1, 3 }
	 { 3, 1, -4 }
	 { 3, 1, 3, 1, -4, -2, -2 }
	 { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }

	
	 Note that the problem deals with sub-arrays which are contiguous i.e. occupy consecutive positions in the array.
	 */

	/*-
	 * Approach 1: Naive solution
	

	Naive solution would be to consider all sub-arrays and find its sum. 
	If sub-array sum is equal to 0, we print it. The time complexity of naive solution is O(n3) as there are n2 sub-arrays 
	and it takes O(n) time to find sum of its elements. The method can be optimized to run in O(n2)
	 time by calculating sub-array sum in constant time.
	 */
	public static void main(String[] args) {
		int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
		printallSubarrays(A);
	}
}
