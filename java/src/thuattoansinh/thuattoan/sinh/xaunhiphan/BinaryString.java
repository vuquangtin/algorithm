package thuattoan.sinh.xaunhiphan;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class BinaryString {
	public static void main(String[] args) {
		generateBinary(3);
	}

	public static void generateBinary(int n) {
		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = 0;
		}
		boolean check = false;
		while (!check) {
			for (int i = 0; i < n; i++) {
				System.out.print(x[i]);
			}
			System.out.println();
			int i = n - 1;
			while (i >= 0 && x[i] == 1) {
				i--;
			}
			if (i >= 0) {
				x[i] = 1;
				for (int j = i + 1; j < n; j++) {
					x[j] = 0;
				}
			} else {
				check = true;
			}
		}
	}
}