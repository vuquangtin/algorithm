package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * Thuật toán quay lui duyệt các tổ hợp chập K của 1, 2, ..,n
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class Combination {
	private static int n, k, X[], count = 0;

	private static void Init() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập n=");
		n = sc.nextInt();
		System.out.print("Nhập k=");
		k = sc.nextInt();
		X = new int[k + 1];
		X[0] = 0;
	}

	private static void Result() {
		System.out.print("Kết quả" + (++count) + ": ");
		for (int i = 1; i <= k; i++)
			System.out.print(X[i] + "  ");
		System.out.println();
	}

	private static void Try(int i) {
		for (int j = X[i - 1] + 1; j <= n - k + i; j++) {
			X[i] = j;
			if (i == k)
				Result();
			else
				Try(i + 1);
		}
	}

	public static void main(String[] args) {
		Init();
		Try(1);
	}
}
