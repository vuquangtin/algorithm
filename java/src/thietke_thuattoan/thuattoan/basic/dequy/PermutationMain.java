package thuattoan.basic.dequy;

import java.util.*;
import java.io.*;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */

public class PermutationMain {
	public static boolean result;

	/*-
	 * https://github.com/PuzzlesLab/UVA/blob/master/oka/3.%20Problem%20Solving%20Paradigms/1.%20Complete%20Search/6.%20Recursive%20Backtracking%20(Easy)/uva10344.java
	 */
	public static void yield(int arr[], int cur, int hold) {

		if (cur == 4) {
			if (hold == 23)
				result = true;
			System.out.println(Arrays.toString(arr));
			return;
		}
		yield(arr, cur + 1, hold + arr[cur + 1]);
		yield(arr, cur + 1, hold - arr[cur + 1]);
		yield(arr, cur + 1, hold * arr[cur + 1]);
	}

	public static void permutation(int arr[], int cur) {
		if (cur == 4) {
			yield(arr, 0, arr[0]);
		}
		for (int i = cur; i < 5; i++) {
			int tmp = arr[cur];
			arr[cur] = arr[i];
			arr[i] = tmp;
			permutation(arr, cur + 1);
			arr[i] = arr[cur];
			arr[cur] = tmp;
		}
	}

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s = br.readLine()).equals("0 0 0 0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			int arr[] = new int[5];
			for (int i = 0; i < 5; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			result = false;
			permutation(arr, 0);
			if (result) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}
}