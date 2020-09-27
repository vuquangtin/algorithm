package thuattoan.btlietke.phuongphapsinh.backtracking;

import java.util.Arrays;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ArrangementEnumeration {
	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		int[] x = new int[k];
		boolean[] c = new boolean[n];
		back(x, c, n, k, 0);
	}

	private static int total = 1;

	static void printArray(int[] x) {
		
		for (int i = 1; i < x.length; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

	static void back(int[] x, boolean[] c, int n, int k, int i) {
		for (int j = 0; j < n; j++) {
			if (!c[j]) {
				x[i] = j;
				if (i == k - 1) {
					System.out.print(total+++"-->");
					System.out.println(Arrays.toString(x));
					// printArray(x);
				} else {
					c[j] = true;
					back(x, c, n, k, i + 1);
					c[j] = false;
				}
			}
		}
	}
}