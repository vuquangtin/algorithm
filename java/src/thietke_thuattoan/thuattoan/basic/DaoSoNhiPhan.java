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
public class DaoSoNhiPhan {

	public int daoso(int n) {
		int s = 0;
		while (n > 0) {
			s = s * 2 + n % 2;
			System.out.println(s);
			n /= 2;
		}
		return s;
	}

	@Test
	public void testDaoSo() {
		assertEquals(new DaoSoNhiPhan().daoso(43), 53);
		assertEquals(new DaoSoNhiPhan().daoso(23), 29);
	}

}