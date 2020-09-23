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
public class ACPC10A {
	/*-
	 * https://github.com/VSZM/JavaSPOJ/blob/master/src/ACPC10A.java
	 */
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while (!(line = br.readLine()).equals("0 0 0")) {
			String[] nums = line.split(" ");
			int A = Integer.parseInt(nums[0]), B = Integer.parseInt(nums[1]), C = Integer
					.parseInt(nums[2]);
			boolean is_ap;

			if (C - B == B - A)
				is_ap = true;
			else
				is_ap = false;

			if (is_ap)
				bw.write("AP " + (C + C - B));
			else
				bw.write("GP " + (C * C / B));

			bw.newLine();
		}

		bw.flush();
	}

}