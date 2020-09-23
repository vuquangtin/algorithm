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

public class Main1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int cnt = 0;
		try {
			int N = Integer.parseInt(br.readLine());
			if (N > 1000)
				return;
			for (int i = 1; i <= N; i++) {
				if (Hansu(i))
					cnt++;
			}

			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static Boolean Hansu(int n) {
		if (n < 100) {
			return true;
		} else if (n < 1000) {
			if (n % 10 - (n / 10) % 10 == (n / 10) % 10 - n / 100)
				return true;
		} else
			return false;
		return false;

	}
}
