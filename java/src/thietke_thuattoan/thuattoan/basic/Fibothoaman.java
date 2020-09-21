package thuattoan.basic;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Fibothoaman {

	public int fiboThoaman(int m, int n) {
		int a = 0;
		int b = 1;
		int count = 0;
		while (b <= n) {
			int temp = a;
			a = b;
			b += temp;
			if (a >= m) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}

	@Test
	public void testFiboThoaman() {
		assertEquals(new Fibothoaman().fiboThoaman(6, 400), 9);
		assertEquals(new Fibothoaman().fiboThoaman(3, 55), 7);
	}
}