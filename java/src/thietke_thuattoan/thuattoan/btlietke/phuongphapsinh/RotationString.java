package thuattoan.btlietke.phuongphapsinh;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class RotationString {
	// Function to find Lexicographically minimal string rotation
	public static String findLexicalMinRotation(String str) {
		// To store lexicographic minimum string
		String min = str;

		for (int i = 0; i < str.length(); i++) {
			// left rotate string by 1 unit
			str = str.substring(1) + str.charAt(0);
			System.out.println(str);
			// check if the rotation is minimum so far
			if (str.compareTo(min) < 0) {
				min = str;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		String str = "bbaaccaadd";

		System.out.println("The lexicographically minimal rotation of " + str
				+ " is " + findLexicalMinRotation(str));
	}
}