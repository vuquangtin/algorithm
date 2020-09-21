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
public class SinhNhiPhan {
	private int i, n, a[];

	public void Init() {
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Nhập vào độ dài xâu nhị phân > 0:");
			this.n = input.nextInt();
		} while (this.n <= 0);

		a = new int[n];
		for (int j = 0; j < n; j++)
			a[j] = 0;
	}

	// hiển thị kết quả
	public void Result() {
		for (int j = 0; j < n; j++) {
			System.out.print(a[j] + "  ");
		}
		System.out.println();
	}

	// Sinh nhị phân
	public void GenerBinary() {
		do {
			Result(); // In ra cấu hình hiện tại
			i = n - 1;
			while (this.i >= 0 && a[i] == 1)
				--i;
			if (this.i >= 0) {
				a[i] = 1;
				for (int j = i + 1; j < n; j++) {
					a[j] = 0;
				}
			}
		} while (this.i >= 0);

	}

	public static void main(String[] agrs) {
		SinhNhiPhan generbinary = new SinhNhiPhan();
		generbinary.Init();
		generbinary.GenerBinary();
		System.gc();
	}
}