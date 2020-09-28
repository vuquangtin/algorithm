package thuattoan.sinh.tohop.learning;

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
public class Combination {

	public static void main(String[] args) {
		int n = 10;
		int m = 4;

		try {
			System.out.println("Total of Combinations: "
					+ getTotal(n, m).toString());
			int[][] combinations = combinations(n, m);
			for (int i = 0; i < combinations.length; i++) {
				Utils.printArray(combinations[i]);
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int[][] combinations(int n, int m) throws Exception {
		if (isValid(n, m)) {
			int totalCombinations = getTotal(n, m).intValue();
			int[][] result = new int[totalCombinations][m];
			int resultIndex = 0;

			int[] array = new int[n];

			// Define all elements
			for (int i = 0; i < n; i++) {
				array[i] = i;
			}

			int[] combination = new int[m];

			// Start first combination
			for (int i = 0; i < m; i++) {
				combination[i] = array[i];
			}

			for (int i = m - 1; i >= 0; i--) {
				int value = combination[i];
				int equivalentIndex = n - m + i;
				int equivalentValue = array[equivalentIndex];
				while (value <= equivalentValue) {
					combination[i] = value;
					result[resultIndex++] = combination.clone();
					value++;
				}
				if (combination[0] < array[n - m]) {
					for (int j = m - 1; j >= 0; j--) {
						equivalentIndex = n - m + j;
						equivalentValue = array[equivalentIndex];
						if (combination[j] < equivalentValue) {
							combination[j]++;
							int k = j + 1;
							while (k <= m - 1) {
								combination[k] = combination[k - 1] + 1;
								k++;
							}
							i++;
							break;
						}
					}
				} else {
					break;
				}
			}
			return result;
		}

		return null;
	}

	public static BigInteger getTotal(int n, int m) throws Exception {
		if (isValid(n, m)) {
			return Utils.factorial(n).divide(
					Utils.factorial(m).multiply(Utils.factorial(n - m)));
		}

		return null;
	}

	private static boolean isValid(int n, int m) throws Exception {
		if (n > 1 && m > 1 && n >= m) {
			return true;
		}
		throw new Exception(
				"N and M must be greater than 1 and N must be grater or equal to M");
	}

}