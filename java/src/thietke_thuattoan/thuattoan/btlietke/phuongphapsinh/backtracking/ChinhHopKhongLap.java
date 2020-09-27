package thuattoan.btlietke.phuongphapsinh.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ChinhHopKhongLap {
	static int count = 1;

	static void Try(int n, int k, int mang[], int i, boolean check[]) {
		int j;
		for (j = 0; j < n; j++) {
			if (check[j] == true) // nếu chưa được gán cho các vị trí phía trước
			{
				mang[i] = j + 1;
				check[j] = false; // đổi lại thành false để các vị trí sau không
									// được dùng nữa

				if (i == (k - 1)) {
					int temp;
					System.out.printf("%d\t", count++);
					for (temp = 0; temp < k; temp++) {
						System.out.printf("%d  ", mang[temp]);
					}
					System.out.printf("\n");
				}

				else {
					Try(n, k, mang, i + 1, check);
				}

				check[j] = true; // gán lại thành true để vì vị trí i hiện sắp
									// tới không sử dụng giá trị j nữa.
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n, k;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Nhap vao n : ");
		n = Integer.parseInt(br.readLine());

		System.out.print("Nhap vao k : ");
		k = Integer.parseInt(br.readLine());

		boolean[] check = new boolean[n];
		// khai báo mảng bool gồm n phần tử

		int i;
		for (i = 0; i < n; i++)
		// khởi tạo giá trị cho mảng bool
		{
			check[i] = true;
		}

		int mang[] = new int[k];

		Try(n, k, mang, 0, check);

	}

}
