package thuattoan.basic.dequy;

import java.util.Arrays;

/**
 * Sinh chuoi nhi phan
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class Example01SinhChuoiNhiPhan {
	public static void Try(int i, int n, int[] x) {
		for (int j = 0; j <= 1; j++) {
			x[i] = j;
			if (i == n - 1) {
				printSolution(x);
			} else {
				Try(i + 1, n, x);
			}
		}
	}

	private static void printSolution(int[] x) {
		System.out.println(Arrays.toString(x));
	}

	public static void main(String[] args) {
		int n = 5;
		int[] x = new int[n];
		Try(0, n, x);
	}
}