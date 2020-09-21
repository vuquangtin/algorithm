package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * 
 * Bài toán n quân hậu
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class NQueen {
	private static int n, X[], count = 0;
	private static boolean cot[], dc_xuoi[], dc_nguoc[];

	private static void Init() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập n = ");
		n = sc.nextInt();
		X = new int[n + 1];
		cot = new boolean[n + 1];
		dc_xuoi = new boolean[2 * n];
		dc_nguoc = new boolean[2 * n];
		for (int i = 1; i <= n; i++)
			cot[i] = true;
		for (int i = 1; i <= (2 * n) - 1; i++) {
			dc_xuoi[i] = true;
			dc_nguoc[i] = true;
		}
	}

	private static void Result() {
		System.out.print("Kết quả " + (++count) + ": ");
		for (int i = 1; i <= n; i++)
			System.out.print(X[i] + "  ");
		System.out.println();
	}

	private static void Try(int i) {
		for (int j = 1; j <= n; j++) {
			if (cot[j] && dc_xuoi[i - j + n] && dc_nguoc[i + j - 1]) {
				X[i] = j;
				cot[j] = false;
				dc_xuoi[i - j + n] = false;
				dc_nguoc[i + j - 1] = false;
				if (i == n)
					Result();
				else
					Try(i + 1);
				cot[j] = true;
				dc_xuoi[i - j + n] = true;
				dc_nguoc[i + j - 1] = true;
			}
		}
	}

	public static void main(String[] args) {
		Init();
		Try(1);
	}

}