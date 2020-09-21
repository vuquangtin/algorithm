package thuattoan.basic;

import static org.junit.Assert.*;

import java.util.HashMap;

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
public class LamatoThapphan {

	public int lamaToThapphan(String str) {
		str = str.toUpperCase();
		int kq = 0;
		int pre = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('I', 1);
		hm.put('X', 10);
		hm.put('C', 100);
		hm.put('M', 1000);
		hm.put('V', 5);
		hm.put('L', 50);
		hm.put('D', 500);
		for (int i = (str.length() - 1); i >= 0; i--) {
			int temp = hm.get(str.charAt(i));
			if (temp < pre) {
				kq -= temp;
			} else {
				kq += temp;
			}
			pre = temp;
		}
		return kq;
	}

	@Test
	public void test_lama_to_thapphan() {
		assertEquals(new LamatoThapphan().lamaToThapphan("MCMLXXXII"), 1982);
		assertEquals(new LamatoThapphan().lamaToThapphan("mmxvii"), 2017);
		assertEquals(new LamatoThapphan().lamaToThapphan("M"), 1000);
	}
}