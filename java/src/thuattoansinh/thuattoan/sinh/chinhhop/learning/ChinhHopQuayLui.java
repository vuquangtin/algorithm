package thuattoan.sinh.chinhhop.learning;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ChinhHopQuayLui {
	private static int n, k;
	private static int[] x, flag;

	public static void main(String[] args) {
		n = 5;
		k = 3;
		x = new int[k];
		flag = new int[n];
		for (int i = 0; i < n; i++)
			flag[i] = 0;
		chinhhop(0);
	}

	private static void chinhhop(int i) {
		int j;
		for (j = 0; j < n; j++) {
			if (flag[j] == 0) {
				x[i] = j + 1;
				flag[j] = 1;
				if (i < k - 1)
					chinhhop(i + 1);
				else
					ket_qua();
				flag[j] = 0;

			}
		}
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < k; i++)
			System.out.print(x[i] + " ");
		System.out.println();

	}
}