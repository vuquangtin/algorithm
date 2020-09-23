package problems.online.leekijong;

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

public class Main15649 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		try {
			int n = Integer.parseInt(br.readLine());

			long fibo = fuc(n);
			bw.write(fibo + "");
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.getMessage();
		}
	}

	static long fuc(int n) {
		long[] fibo = new long[91];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= n; i++)
			fibo[i] = fibo[i - 2] + fibo[i - 1];

		return fibo[n];

	}
}