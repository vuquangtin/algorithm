package thuattoan.test;

import java.math.BigInteger;

import thuattoan.sinh.chinhhop.learning.Arrangement;
import thuattoan.sinh.hoanvi.learning.Permutation;
import thuattoan.sinh.tohop.learning.Combination;
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
public class ApplicationTest {

	public static void main(String[] args) {
		challenge();
		comparation();
	}

	private static void challenge() {
		int n = 10;
		int m = 4;

		try {
			System.out
					.println("Total of Permutations for each combination (tp): "
							+ Permutation.getTotal(4).toString());
			System.out.println("Total of Combinations (tc): "
					+ Combination.getTotal(n, m).toString());
			BigInteger totalArrangements = Combination.getTotal(n, m).multiply(
					Permutation.getTotal(m));
			System.out.println("tp * tc: " + totalArrangements.toString());
			System.out.println("Total of Arrangements: "
					+ Arrangement.getTotal(n, m).toString());

			int[][] combinations = Combination.combinations(n, m);
			for (int[] combination : combinations) {
				Permutation.permute(combination);
			}

			// OR

			int[][] arrangements = Arrangement.arrangement(n, m);
			for (int[] arrengement : arrangements) {
				Utils.printArray(arrengement);
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	private static void comparation() {
		int n = 10;
		int m = 4;

		try {

			long startTime = System.nanoTime();
			int[][] combinations = Combination.combinations(n, m);
			for (int[] combination : combinations) {
				Permutation.permute(combination);
			}
			long endTime = System.nanoTime();

			long cpDuration = (endTime - startTime) / 1000000;

			System.out
					.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			// OR
			startTime = System.nanoTime();
			int[][] arrangements = Arrangement.arrangement(n, m);
			for (int[] arrengement : arrangements) {
				Utils.printArray(arrengement);
			}
			endTime = System.nanoTime();
			long aDuration = (endTime - startTime) / 1000000;

			System.out.println("COMBINATION + PERMUTATION: " + cpDuration);
			System.out.println("ARRANGEMENT              : " + aDuration);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}