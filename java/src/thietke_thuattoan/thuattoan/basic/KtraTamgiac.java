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
public class KtraTamgiac {

	public String ktratgiac(double a, double b, double c) {
		double x;
		double s;
		if ((a + b > c) && (a + c > b) && (b + c > a)) {
			x = (a + b + c) / 2;
			s = Math.sqrt(x * (x - a) * (x - b) * (x - c));
			if ((a * a == b * b + c * c) || (b * b == a * a + c * c)
					|| (c * c == a * a + b * b)) {
				return String.format(
						"Tam giac vuong. Dien tich: %.2f. Chu vi: %.2f", s,
						2 * x);
			} else {
				if ((a == b) && (a == c)) {
					return String.format(
							"Tam giac deu. Dien tich: %.2f. Chu vi: %.2f", s,
							2 * x);
				} else {
					if ((a == b) || (b == c) || (a == c)) {
						return String.format(
								"Tam giac can. Dien tich: %.2f. Chu vi: %.2f",
								s, 2 * x);
					} else {
						return String
								.format("Tam giac thuong. Dien tich: %.2f. Chu vi: %.2f",
										s, 2 * x);
					}
				}
			}
		} else {
			return "Tam giac khong ton tai!!!";
		}
	}

	@Test
	public void testKtratgiac() {
		assertEquals(new KtraTamgiac().ktratgiac(3, 4, 5),
				"Tam giac vuong. Dien tich: 6.00. Chu vi: 12.00");
		assertEquals(new KtraTamgiac().ktratgiac(6, 6, 8),
				"Tam giac can. Dien tich: 17.89. Chu vi: 20.00");
		assertEquals(new KtraTamgiac().ktratgiac(4, 5, 7),
				"Tam giac thuong. Dien tich: 9.80. Chu vi: 16.00");
		assertEquals(new KtraTamgiac().ktratgiac(4, 5, 10),
				"Tam giac khong ton tai!!!");
		assertEquals(new KtraTamgiac().ktratgiac(5, 5, 5),
				"Tam giac deu. Dien tich: 10.83. Chu vi: 15.00");
	}
}