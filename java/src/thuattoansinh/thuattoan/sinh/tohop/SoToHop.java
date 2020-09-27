package thuattoan.sinh.tohop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class SoToHop {
	public static int C(int k, int n) {
		if (k == 0 || k == n)
			return 1;
		if (k == 1)
			return n;
		return C(k - 1, n - 1) + C(k, n - 1);
	}

	static long gt(int n) {
		long s = 1;
		for (int i = 1; i <= n; i++)
			s *= i;
		return s;
	}

	static long lapC(int k, int n) {
		return gt(n) / (gt(k) * gt(n - k));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n, k;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Nhap k: ");
		k = Integer.parseInt(br.readLine());
		System.out.print("Nhap n: ");
		n = Integer.parseInt(br.readLine());
		System.out.print("To hop bang: " + C(k, n));
		System.out.println("To hop lap bang: " + lapC(k, n));

	}
}
