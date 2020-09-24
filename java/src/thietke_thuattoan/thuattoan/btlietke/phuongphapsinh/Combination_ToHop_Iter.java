package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/

 *      vuquangtin/algorithm</a>
 *
 */
public class Combination_ToHop_Iter {
	private int i, n, k, a[];

	public void Init() {
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Nhập vào số phần tử n >=0:");
			this.n = input.nextInt();
			System.out.print("Nhập vào số tổ hợp  k <= n:");
			this.k = input.nextInt();
		} while (this.n < 0 || this.k > this.n);

		a = new int[n + 1];
		for (int j = 1; j <= this.k; j++)
			a[j] = j;
	}

	// Hiển thị kết quả
	public void Result() {
		for (int j = 1; j <= k; j++)
			System.out.print(a[j] + "  ");
		System.out.println();
	}

	// Sinh tổ hợp
	public void sinhToHop() {
		do {
			Result();
			this.i = this.k;
			// System.out.println(i + "\t" + k + "\t" + n);
			while (this.i > 0 && a[i] == this.n - this.k + i)
				--i;
			if (this.i > 0) {
				a[i]++;
				for (int j = i + 1; j <= this.k; j++) {
					a[j] = a[j - 1] + 1;
				}
			}

		} while (this.i != 0);

	}

	public static void main(String[] agrs) {
		Combination_ToHop_Iter tohop = new Combination_ToHop_Iter();
		tohop.Init();
		tohop.sinhToHop();
		System.gc();
	}
}