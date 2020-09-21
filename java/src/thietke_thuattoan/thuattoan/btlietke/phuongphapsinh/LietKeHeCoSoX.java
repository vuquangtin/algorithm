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
public class LietKeHeCoSoX {
	static int count;
	static int n;
	static String[] x = new String[100];
	static final String[] HE_SO_2 = { "0", "1" };
	static final String[] HE_SO_HEXA = { "0", "1","2","3","4","5","6","7","8","9","A","B","C","D","E","F" };
	static final String[] HE_SO_8 = { "0", "1","2","3","4","5","6","7" };
	static String[] HE_SO;

	public static void printSolution() {
		count++;
		// System.out.println("configuration " + count);
		for (int i = 0; i < n; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

	public static void TRY(int k) {
		for (int v = 0; v < HE_SO.length; v++) {
			x[k] = HE_SO[v];
			if (k == n - 1) {
				printSolution();
			} else {
				TRY(k + 1);
			}

		}
	}

	public static void main(String[] args) {
		HE_SO = HE_SO_8;
		n = 3;
		count = 0;
		TRY(0);
	}
}