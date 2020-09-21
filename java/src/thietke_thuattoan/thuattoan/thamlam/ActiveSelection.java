package thuattoan.thamlam;

import java.util.Scanner;

/**
 * 
 * Thuật toán tham lam giải bài toán Active Selection Problem
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ActiveSelection {
	private static int n;// số lượng hành động
	private static int S[];// thời gian bắt đầu
	private static int F[];// thời gian kết thúc
	private static boolean OTP[];// phương án tối ưu

	private static void Init() { // khởi tạo tham số ban đầu
		Scanner sc = new Scanner(System.in);
		System.out.print("Số lượng hành động:");
		n = sc.nextInt();
		S = new int[n + 1];
		F = new int[n + 1];
		OTP = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			System.out.println("Hành động  " + i + " : ");
			System.out.println("Thời gian bắt đầu S[" + i + "]=");
			S[i] = sc.nextInt();
			System.out.println("Thời gian kết thúc F[" + i + "]=");
			F[i] = sc.nextInt();
			OTP[i] = false; // thiết lập phương án tối ưu là false
		}
	}

	private static void Sapxep() { // sắp xếp tăng dần theo thời gian kết thúc
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (F[i] > F[j]) {
					int t1 = F[i];
					F[i] = F[j];
					F[j] = t1;
					int t2 = S[i];
					S[i] = F[j];
					S[j] = t2;
				}
			}
		}
	}

	private static void Result() { // phương án tối ưu
		System.out.println("Phương án tối ưu");
		for (int i = 1; i <= n; i++) {
			if (OTP[i])
				System.out.print(i + " ");
		}
	}

	private static void Greedy_Solution() {
		Init(); // Xây dựng tập giải pháp
		Sapxep(); // Sắp xếp
		OTP[1] = true;
		int i = 1;// giải pháp tối ưu lúc đầu là 1
		for (int j = 1; j <= n; j++) {
			if (S[j] >= F[i]) { // lựa chọn giải pháp cục bộ
				OTP[j] = true; // lựa chọn hành động j
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		Greedy_Solution();
		Result();
	}

}