package thuattoan.btlietke.phuongphapsinh.backtracking;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CombinationEnumeration {
	public static void main(String[] args) {
		int[] x = new int[4];
		x[0] = 0;
		back(x, 5, 3, 1);
	}

	static void printArray(int[] x) {
		for (int i = 1; i < x.length; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

	static void back(int[] x, int n, int k, int i) {
		for (int j = x[i - 1] + 1; j <= n - k + i; j++) {
			x[i] = j;
			if (i == k) {
				printArray(x);
			} else {
				back(x, n, k, i + 1);
			}
		}
	}
}