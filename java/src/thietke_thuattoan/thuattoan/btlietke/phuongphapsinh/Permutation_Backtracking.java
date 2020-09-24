package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * Thuật toán quay lui duyệt các hoán vị của 1, 2,..,n
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class Permutation_Backtracking {
	private static int n, X[], count = 0;
	private static boolean chuaxet[];

	private static void Init() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập n = ");
		n = sc.nextInt();
		X = new int[n + 1];
		chuaxet = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			chuaxet[i] = true;
	}

	private static void Result() {
		System.out.print("Kết quả " + (++count) + ": ");
		for (int i = 1; i <= n; i++)
			System.out.print(X[i] + "  ");
		System.out.println();
	}

	private static void Try(int i) {
		for (int j = 1; j <= n; j++) {
			if (chuaxet[j]) {
				X[i] = j;
				chuaxet[j] = false;
				if (i == n)
					Result();
				else
					Try(i + 1);
				chuaxet[j] = true;
			}
		}
	}

	public static void main(String[] args) {
		Init();
		Try(1);
	}

}