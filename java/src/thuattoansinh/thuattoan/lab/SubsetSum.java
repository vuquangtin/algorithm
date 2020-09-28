package thuattoan.lab;

import java.util.Arrays;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SubsetSum {
	public static void main(String[] args) {
		int[] s = new int[] { 2, 3, 1, 1, 6 };
		for (int i = 0; i < s.length; i++) {
			subsetSum(s, i + 1);
		}
	}

	static void subsetSum(int[] s, int k) {
		int[] a = new int[k];
		int[] position = new int[k];
		for (int i = 0; i < k; i++) {
			a[i] = s[i];
			position[i] = i;
		}

		boolean check = true;

		while (check) {
			System.out.println(Arrays.toString(a));
			int i = k - 1;
			while (i >= 0 && a[i] == s[s.length - k + i]) {
				i--;
			}
			if (i >= 0) {
				a[i] = s[++position[i]];
				for (int j = i + 1; j < k; j++) {
					a[j] = s[position[j - 1] + 1];
					position[j] = position[j - 1] + 1;
				}
			} else {
				check = false;
			}
		}
	}
}