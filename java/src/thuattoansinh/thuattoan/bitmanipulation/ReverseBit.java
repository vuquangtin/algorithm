package thuattoan.bitmanipulation;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ReverseBit {
	public static void main(String[] args) {
		System.out.println(reverseBit(43261596));
	}

	static int reverseBit(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
		return n;
	}

	static int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;
		if ((a ^ b) != 0) {
			return n ^ ((1 << i) | (1 << j));
		}
		return n;
	}
}