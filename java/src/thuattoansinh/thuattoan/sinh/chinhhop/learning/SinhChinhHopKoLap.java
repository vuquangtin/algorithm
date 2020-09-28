package thuattoan.sinh.chinhhop.learning;

import java.util.Arrays;

/**
 * A(3,5)=5.4.3.2.1/2.1=60
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class SinhChinhHopKoLap {
	// https://github.com/tranthienbinh1989/algorithms/tree/master/src
	public static void main(String[] args) {
		sinhChinhHopKoLap(5, 3);
	}

	static void sinhChinhHopKoLap(int n, int k) {
		int[] x = new int[k];
		for (int i = 0; i < k; i++) {
			x[i] = i;
		}

		boolean check = false;
		int count = 0;
		while (!check) {
			boolean[] mark = new boolean[n];
			for (int i = 0; i < k; i++) {
				// danh dau cac phan tu da su dung
				mark[x[i]] = Boolean.TRUE;
			}
			count++;
			System.out.print(count + ":" + Arrays.toString(x));
			System.out.println();

			int i = k - 1;
			boolean flag = false;
			while (i >= 0) {
				// release current element
				mark[x[i]] = Boolean.FALSE;
				for (int j = x[i] + 1; j < n; j++) {
					if (!mark[j]) {
						x[i++] = j;
						// mark as used
						mark[j] = Boolean.TRUE;

						for (int m = 0; m < n && i < k; m++) {
							if (!mark[m]) {
								x[i++] = m;
							}
						}
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
				i--;
			}
			if (!flag) {
				check = true;
			}
		}
		System.out.println(count);
	}
}