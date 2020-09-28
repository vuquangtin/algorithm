package thuattoan.sinh.hoanvi.learning;

import java.math.BigInteger;

import thuattoan.utils.Utils;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Permutation {

	public static void main(String[] args) {
		int n = 4;
		try {

			System.out.println("Total of Permutations: "
					+ getTotal(n).toString());
			permute(n);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public static void permute(int n) throws Exception {
		if (isValid(n)) {
			int[] array = new int[n];

			// Define all elements
			for (int i = 0; i < n; i++) {
				array[i] = i;
			}

			permute(array, 0);

		} else {
			System.out.println("N must be higher than 1");
		}
	}

	public static void permute(int[] array) throws Exception {
		if (isValid(array.length)) {
			permute(array, 0);
		}
	}

	private static void permute(int[] array, int index) {
		if (index >= array.length - 1) {
			Utils.printArray(array);
			return;
		}

		for (int i = index; i < array.length; i++) {
			// Swap
			int t = array[index];
			array[index] = array[i];
			array[i] = t;

			permute(array, index + 1);

			// Swap back
			t = array[index];
			array[index] = array[i];
			array[i] = t;
		}
	}

	public static BigInteger getTotal(int n) throws Exception {
		if (isValid(n)) {
			return Utils.factorial(n);
		}

		return null;
	}

	private static boolean isValid(int n) throws Exception {
		if (n > 1) {
			return true;
		}
		throw new Exception("N must be greater than 1");
	}

}