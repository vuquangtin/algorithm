package thuattoan.basic;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CrazyFibonacci {
	public int crazyfibo(int a0, int a1, int a2, int a3, int a4, int n) {
		Integer array[] = { a0, a1, a2, a3, a4 };
		int count = 4;
		while (count < n) {
			int sum = 0;
			for (int i = 0; i <= 4; i++) {
				sum += array[i];
				if (i != 4) {
					array[i] = array[i + 1];
				} else {
					array[i] = sum % 10;
				}
			}
			count++;
		}
		return (n > 4) ? array[4] : array[n];
	}

	public static void main(String[] args) {
		System.out.println(new CrazyFibonacci()
				.crazyfibo(10, 12, 24, 35, 23, 1));
		System.out.println(new CrazyFibonacci().crazyfibo(6, 2, 2, 1, 4, 8)
				+ "=" + 0);
		System.out.println(new CrazyFibonacci().crazyfibo(6, 2, 2, 1, 4, 6)
				+ "=" + 4);
		System.out.println(new CrazyFibonacci().crazyfibo(6, 2, 2, 1, 4, 3)
				+ "=" + 1);
	}
}