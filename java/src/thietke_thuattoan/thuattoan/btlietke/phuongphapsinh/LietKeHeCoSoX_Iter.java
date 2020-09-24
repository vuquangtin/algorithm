package thuattoan.btlietke.phuongphapsinh;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/

 *      vuquangtin/algorithm</a>
 *
 */
public class LietKeHeCoSoX_Iter {
	static int count;
	static int n;
	// static String[] x = new String[100];
	static final String[] HE_SO_2 = { "0", "1" };
	static final String[] HE_SO_HEXA = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F" };
	static final String[] HE_SO_8 = { "0", "1", "2", "3", "4", "5", "6", "7" };
	static String[] HE_SO;

	private void Result() {
		System.out.print("Xâu thứ " + (++count) + ":");
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}

	private int i;
	private String a[];

	public void GenerHeCoSoX() {
		int index = 1;
		do {
			Result(); // In ra cấu hình hiện tại
			i = n - 1;
			while (this.i >= 0 && a[i] == HE_SO[HE_SO.length - 1]) {
				--i;
				// index = 1;
			}
			if (this.i >= 0) {
				if (index >= HE_SO.length) {
					index = 1;
					a[i] = HE_SO[index];
				} else {
					a[i] = HE_SO[index++];
				}
				for (int j = i + 1; j < n; j++) {
					a[j] = HE_SO[0];
				}
			}
		} while (this.i >= 0);

	}

	public void Init() {
		// Scanner input = new Scanner(System.in);
		// do {
		// System.out.print("Nhập vào độ dài xâu nhị phân > 0:");
		// this.n = input.nextInt();
		// } while (this.n <= 0);
		HE_SO = HE_SO_8;
		n = 3;
		a = new String[n];
		count = 0;
		for (int j = 0; j < n; j++)
			a[j] = "0";
	}

	public static void main(String[] args) {
		LietKeHeCoSoX_Iter lk = new LietKeHeCoSoX_Iter();
		lk.Init();
		lk.GenerHeCoSoX();
	}
}