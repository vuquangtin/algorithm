package thuattoan.basic.dequy;

import java.util.Arrays;

/**
 * Sinh chuỗi nhị phân với điều kiện không có 2 số 1 cạnh nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class Example03SinhChuoiNhiPhanVoiDK {
	public static void Try(int i, int n, int[] x) {
		for (int j = 0; j <= 1; j++) {
			if (check(i, j, x)) {
				x[i] = j;
				if (i == n - 1) {
					printSolution(x);
				} else {
					Try(i + 1, n, x);
				}
			}
		}
	}

	private static boolean check(int i, int j, int[] x) {
		if (i == 0)
			return true;
		if (x[i - 1] + j == 2)
			return false;
		return true;
	}

	private static void printSolution(int[] x) {
		System.out.println(Arrays.toString(x));
	}

	public static void main(String[] args) {
		int n = 4;
		int[] x = new int[n];
		Try(0, n, x);
	}
}