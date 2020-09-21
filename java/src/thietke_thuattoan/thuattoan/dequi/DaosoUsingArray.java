package thuattoan.dequi;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class DaosoUsingArray {

	public int daoSo(int n) {
		int result = 0;
		int temp;
		while (n > 0) {
			temp = n % 10;
			result = result * 10 + temp;
			n /= 10;
		}
		return result;
	}

	public int daoSo(int[] a) {
		int sum = 0;
		for (int i : a) {
			i = daoSo(i);
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new DaosoUsingArray().daoSo(138494));
	}
}