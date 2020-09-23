package thuattoan.basic.stream.system.inout;

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
public class InputAndOutput {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("Enter number : ");
		bw.flush();
		int n = Integer.parseInt(br.readLine());
		bw.flush();
		while (n > 0) {
			bw.write("Enter number : ");
			bw.flush();
			n = Integer.parseInt(br.readLine());
			bw.flush();
		}

		bw.write("The factorial of " + n + " is " + 100);
		bw.flush();
	}

	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		int count = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < count; i++) {
			String num_all = br.readLine();
			String[] num = num_all.split(" ");
			int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
			bw.write(sum + "\n");
		}

		bw.flush();
		bw.close();

	}
}