package problems.online.ACPC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ENIGMATH {

	static int gcd(int a, int b) {
		int c;
		while (a != 0) {
			c = a;
			a = b % a;
			b = c;
		}
		return b;
	}

	static long lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	/*-
	 * https://github.com/VSZM/JavaSPOJ/blob/master/src/ENIGMATH.java
	 */
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());

		while (caseCount-- > 0) {
			String[] nums = br.readLine().split(" ");
			int A = Integer.parseInt(nums[0]), B = Integer.parseInt(nums[1]);
			int gcd = gcd(A, B);

			bw.write(B / gcd + " " + A / gcd);
			bw.newLine();
		}

		bw.flush();
	}
}