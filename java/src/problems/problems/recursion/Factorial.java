package problems.recursion;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class Factorial {
	/*-
	 * Factorial is the product of all numbers from 1 to n.
	 * Example : 5! = 5 x 4 x 3 x 2 x 1 = 120
	 * This can also be written as 5! = 5 x 4!
	 */
	private static long factorial(int num) {
		if (num <= 1) // 1! = 1, hence return 1 when the num becomes 1.
			return 1;
		return num * factorial(num - 1); // num! = num * (num - 1)!
	}

	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
}