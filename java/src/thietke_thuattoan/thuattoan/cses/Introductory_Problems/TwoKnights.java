package thuattoan.cses.Introductory_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class TwoKnights {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		for (int k = 1; k <= n; k++) {
			int k2 = k * k;
			pw.println((long) k2 * (k2 - 1) / 2 - (k - 1) * (k - 2) * 4);
		}
		pw.close();
	}
}
