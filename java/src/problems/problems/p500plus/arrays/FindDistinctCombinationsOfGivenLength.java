package problems.p500plus.arrays;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class FindDistinctCombinationsOfGivenLength {

	// Function to print all distinct combinations of length k
	public static void recur(int[] A, String out, int i, int n, int k) {
		// invalid input
		if (k > n) {
			return;
		}

		// base case: combination size is k
		if (k == 0) {
			System.out.println(out);
			return;
		}

		// start from next index till last index
		for (int j = i; j < n; j++) {
			// add current element A[j] to solution & recur for next index
			// (j+1) with one less element (k-1)
			recur(A, out + " " + (A[j]), j + 1, n, k - 1);

			// uncomment below code to handle duplicates

			// while (j < n - 1 && A[j] == A[j + 1]) {
			// j++;
			// }

		}
	}

	/*-
	 * For example,

	 Input:  {1, 2, 3}, k = 2
	 Output: {1, 2}, {1, 3}, {2, 3}
	
	
	 Input:  {1, 2, 1}, k = 2
	 Output: {1, 1}, {1, 2}

	
	 The program should print only distinct combinations. For example, for above input, either {1, 2} or {2, 1} should be considered.
	

	

	 We can use recursion to solve this problem. The idea is to add each element in the output and recur for remaining elements with one less element.
	  To avoid printing permutations, each combination will be constructed in same order as array elements. 
	  If combination of given size is found, we print it. Below solution generates all combinations by using 
	  above logic by traversing the array from left to right. To print only distinct combinations in case input contains repeated 
	  elements, we can sort the array and exclude all adjacent duplicate elements from the array.
	 */
	// Find all distinct combinations of given length
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		int k = 3;

		// if array contains repeated elements,
		// sort the array to handle duplicate combinations
		// Arrays.sort(A);

		// process elements from left to right
		recur(A, "", 0, A.length, k);
	}

}
