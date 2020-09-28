package thuattoan.sinh.chinhhop.learning;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.TreeSet;

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
public class Arrangement {
	// https://github.com/henrique-pan/must-know-practice
	public static void main(String[] args) {

		int n = 10;
		int m = 4;

		try {
			System.out.println("Total of Arrangements: "
					+ getTotal(n, m).toString());
			int[][] arrangements = arrangement(n, m);
			for (int i = 0; i < arrangements.length; i++) {
				Utils.printArray(arrangements[i]);
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int[][] arrangement(int n, int m) throws Exception {
		if (isValid(n, m)) {
			int totalArrangements = getTotal(n, m).intValue();
			int[][] result = new int[totalArrangements][m];
			int resultIndex = 0;

			int[] array = new int[n];

			// Define all elements
			for (int i = 0; i < n; i++) {
				array[i] = i;
			}

			int[] arrangement = new int[m];

			// Start first arrangement
			TreeSet<Integer> availableValues = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				if (i < m - 1) {
					arrangement[i] = array[i];
				} else {
					availableValues.add(array[i]);
				}
			}

			int lastIndex = m - 1;
			int equivalentValue = array[n - 1];
			while (arrangement[0] <= equivalentValue) {
				// GENERATE ARRAGEMENTS
				for (int availableValue : availableValues) {
					arrangement[lastIndex] = availableValue;
					result[resultIndex++] = arrangement.clone();
				}
				// GENERATE ARRANGEMENTS

				if (arrangement[0] == 9 && arrangement[1] == 8
						&& arrangement[2] == 6 && arrangement[3] == 7) {
					System.out.println("");
				}

				// INCREMENTS M
				boolean shouldOrganize = false;
				int biggerIndex = 0;
				for (int i = lastIndex - 1; i >= 0; i--) {
					boolean hasBigger = false;
					Iterator<Integer> iterator = availableValues.iterator();
					int nextValue = 0;
					while (iterator.hasNext() && !hasBigger) {
						nextValue = iterator.next();
						if (arrangement[i] < nextValue) {
							hasBigger = true;
						}
					}
					if (hasBigger) {
						availableValues.add(arrangement[i]);
						arrangement[i] = nextValue;
						availableValues.remove(nextValue);
						break;
					} else {
						shouldOrganize = true;
						biggerIndex = i;
						availableValues.add(arrangement[i]);
					}
				}
				// INCREMENTS M

				// ORGANIZE M
				if (shouldOrganize) {
					for (int i = lastIndex - 1; i >= biggerIndex; i--) {
						arrangement[i] = availableValues.first();
					}
					for (int i = biggerIndex; i < lastIndex; i++) {
						boolean hasBigger = false;
						Iterator<Integer> iterator = availableValues.iterator();
						int nextValue = 0;
						while (iterator.hasNext() && !hasBigger) {
							nextValue = iterator.next();
							if (arrangement[i] <= nextValue) {
								hasBigger = true;
							}
						}
						if (hasBigger) {
							availableValues.add(arrangement[i]);
							arrangement[i] = nextValue;
							availableValues.remove(nextValue);
						} else {
							availableValues.add(arrangement[i]);
							arrangement[i] = availableValues.pollFirst();
						}
					}
					// VALIDATE AVAILABLES
					for (int i = 0; i < lastIndex - 1; i++) {
						if (availableValues.contains(arrangement[i])) {
							availableValues.remove(arrangement[i]);
						}
					}
					// VALIDATE AVAILABLES
				}
				// ORGANIZE M

				// VERIFY END
				boolean didFinished = false;
				for (int i = 0; i < m - 1; i++) {
					for (int j = i + 1; j < m - 1; j++) {
						if (arrangement[i] == arrangement[j]) {
							didFinished = true;
							break;
						}
					}
				}
				if (didFinished)
					break;
				// VERIFY END
			}
			return result;
		}

		return null;
	}

	public static BigInteger getTotal(int n, int m) throws Exception {
		if (isValid(n, m)) {
			return Utils.factorial(n).divide(Utils.factorial(n - m));
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