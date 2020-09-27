package problems.online.hustoj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import algorithm.utilities.Resource;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class Problem1006 {
	int[] arr;
	int n;
	int k;
	int i;
	int count = 0;

	public void init() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(Resource.PATH_INPUT_HUTSTOJ + "1006.inp")));
			String[] lines = br.readLine().split("\\s+");
			n = Integer.parseInt(lines[0]);
			k = Integer.parseInt(lines[1]);
			i = Integer.parseInt(lines[2]);
			System.out.println(n + "\t" + k + "\t" + i);
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = 0;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void solve() {
		int index = n - 1;
		while (index >= 0) {
			while (index >= 0 && arr[index] == 1)
				index--;
			if (index >= 0) {
				arr[index] = 1;
				for (int i = index + 1; i < n; i++) {
					arr[i] = 0;
				}
				printSolution();
				index = n - 1;
			}

		}

	}

	private void printSolution() {
		int j = 0;
		int total = 0;
		while (j < n) {
			if (arr[j] == 0) {
				total++;
				if (total == i) {
					break;
				}
			} else {
				total = 0;
			}
			j++;
		}
		if (total < i && ++count == k)
			System.out.println(Arrays.toString(arr));

	}

	public static void main(String[] args) {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// try {
		// br.readLine();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		Problem1006 problem = new Problem1006();
		problem.init();
		problem.solve();
	}

}
