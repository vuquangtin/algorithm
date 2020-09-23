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

public class Main15650 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		try {
			int T = Integer.parseInt(br.readLine());

			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());
				fuc(N);
			}
			bw.write(sb + "");
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.getMessage();
		}
	}

	static void fuc(int N) {
		int fibo[][] = new int[41][2];
		fibo[0][0] = 1;
		fibo[1][1] = 1;
		if (N == 0) {
			sb.append("1 0\n");
		} else if (N == 1) {
			sb.append("0 1\n");
		} else {
			for (int i = 2; i <= N; i++) {
				fibo[i][0] = fibo[i - 2][0] + fibo[i - 1][0];
				fibo[i][1] = fibo[i - 2][1] + fibo[i - 1][1];
			}
			sb.append(fibo[N][0] + " " + fibo[N][1] + "\n");
		}

	}
}