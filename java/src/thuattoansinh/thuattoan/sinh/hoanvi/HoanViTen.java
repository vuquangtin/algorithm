package thuattoan.sinh.hoanvi;

import java.util.Scanner;

/**
 * 
 * Nhập vào danh sách n tên người, in ra tất cả các cách xếp n người đó vào 1
 * bàn (liệt kê hoán vị )
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class HoanViTen {
	public void init(String[] arr, int n) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập tên người: ");
			arr[i] = scanner.nextLine();
		}

	}

	public void giaiThuat(int n) {
		int i, k, temp, a, b;
		int[] arr = new int[n];
		String[] array = new String[n];
		init(array, n);

		for (i = 0; i < n; i++) {
			arr[i] = i;
		}
		do {
			for (i = 0; i < n; i++) {
				System.out.print(array[arr[i]] + "\t");
			}
			System.out.println();
			i = n - 2;
			while (i >= 0 && arr[i] > arr[i + 1]) {
				i--;
			}
			if (i >= 0) {

				k = n - 1;
				while (arr[i] > arr[k]) {
					k--;
				}
				if (k >= 0) {
					temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;

					a = i + 1;
					b = n - 1;
					while (a < b) {
						temp = arr[a];
						arr[a] = arr[b];
						arr[b] = temp;
						a++;
						b--;
					}

				}

			}

		} while (i >= 0);

	}

	public static void main(String[] args) {
		HoanViTen baiTap6 = new HoanViTen();
		baiTap6.giaiThuat(3);

	}
}