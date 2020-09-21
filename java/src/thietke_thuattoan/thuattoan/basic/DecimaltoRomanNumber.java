package thuattoan.basic;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class DecimaltoRomanNumber {

	public String decToRoman(int input) {
		if (input < 1 || input > 3999) {
			return "Invalid Roman Number Value";
		}
		TreeMap<Integer, String> hmap = new TreeMap<>(Comparator.reverseOrder());
		hmap.put(1000, "M");
		hmap.put(900, "CM");
		hmap.put(500, "D");
		hmap.put(400, "CD");
		hmap.put(100, "C");
		hmap.put(90, "XC");
		hmap.put(50, "L");
		hmap.put(40, "XL");
		hmap.put(10, "X");
		hmap.put(9, "IX");
		hmap.put(5, "V");
		hmap.put(4, "IV");
		hmap.put(1, "I");
		String s = "";
		for (Map.Entry<Integer, String> sethmap : hmap.entrySet()) {
			int key = sethmap.getKey();
			for (int i = 0; i < input / key; i++) {
				s += hmap.get(key);
			}
			input %= key;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(new DecimaltoRomanNumber().decToRoman(1325));
	}
}