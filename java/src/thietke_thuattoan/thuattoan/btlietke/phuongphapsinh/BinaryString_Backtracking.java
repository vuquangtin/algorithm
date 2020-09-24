package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * Thuật toán quay lui duyệt các xâu nhị phân có độ dài n
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class BinaryString_Backtracking {
	private static int n, X[], count = 0;

	private static void Init() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập n=");
		n = sc.nextInt();
		X = new int[n + 1];
	}

	private static void Result() {
		System.out.print("Xâu thứ " + (++count) + ":");
		for (int i = 1; i <= n; i++)
			System.out.print(X[i] + "  ");
		System.out.println();
	}

	private static void Try(int i) {
		for (int j = 0; j <= 1; j++) {
			X[i] = j;
			if (i == n)
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
