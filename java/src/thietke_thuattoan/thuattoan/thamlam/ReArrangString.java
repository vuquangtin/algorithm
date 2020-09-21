package thuattoan.thamlam;

/**
 * Sắp đặt lại các xâu ký tự sao cho tất cả các ký tự giống nhau đều có khoảng
 * cách d cho trước. Ví dụ STR="ABB", d = 2 ta có STR="BAB"
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ReArrangString {
	private static int d; // khoảng cách các ký tự giống nhau
	private static String str; // xâu ký tự cho trước
	private static char[] kytu; // tập ký tự trong str
	private static int Fred[]; // tần xuất xuất hiện các ký tự trong xâu

	private static void Tap_Kytu() {
		char[] s = str.toCharArray();
		Fred = new int[256];
		kytu = new char[256];
		for (int i = 0; i < 256; i++) {
			Fred[i] = 0;
			kytu[i] = 0;
		}
		for (int i = 0; i < s.length; i++) {// tìm tần xuất xuất hiện mỗi ký tự
			kytu[s[i]] = s[i];
			Fred[s[i]]++;
		}
	}

	private static void Sapxep() {// sắp xếp theo thứ tự tăng dần của Fred[]

		for (int i = 0; i < 255; i++) {

			for (int j = i + 1; j < 256; j++) {
				if (Fred[i] < Fred[j]) {
					int tmp = Fred[i];
					Fred[i] = Fred[j];
					Fred[j] = tmp;
					char t = kytu[i];
					kytu[i] = kytu[j];
					kytu[j] = t;
				}
			}
		}
	}

	private static int Count() {
		int dem = 0;
		for (int i = 0; i < 256; i++) {
			if (Fred[i] != 0)
				dem++;
		}
		return dem;
	}

	private static void Greedy_Solution() {
		Tap_Kytu();
		Sapxep();
		int m = Count();
		char X[] = new char[str.length()];
		boolean chuaxet[] = new boolean[str.length()];
		for (int p = 0; p < str.length(); p++)
			chuaxet[p] = true;
		for (int i = 0; i < m; i++) {
			int p = 0;// lấy max của Fred[i]
			while (!chuaxet[p])
				p++;
			// điền vi trí p, p + d, p+2d, ...p+(Fred[i]*d
			for (int k = 0; k < Fred[i]; k++) {
				if (p + d * k >= str.length()) {
					System.out.println("Không sắp đặt được");
					return;
				}
				X[p + (d * k)] = kytu[i];
				chuaxet[p + (d * k)] = false;
			}

		}
		str = String.copyValueOf(X);
		System.out.println("Str = " + str);
	}

	public static void main(String[] args) {
		str = "GEEKSFORGEEKS";
		d = 3;
		Greedy_Solution();
	}

}