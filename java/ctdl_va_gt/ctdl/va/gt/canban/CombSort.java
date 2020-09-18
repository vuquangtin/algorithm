package ctdl.va.gt.canban;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import ctdl.va.gt.create.examp.CreateInput;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CombSort {
	/*-
	 * Dung thuat toan CombSort de sap xep
	 * Thuat toan sap xep dung he so shrink de tinh khoang cach giua cac phan tu can
	 * sap xep
	 * Sau moi luot thi shrink duoc chia nho lai, den khi = 1 thi dung lai
	 * Khi do day da duoc sap xep
	 * Do phuc tap thuat toan: O(n) - O(nlog(n))
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(CreateInput.PATH_OUTPUT_FILE
						+ "combsort.inp")));
		int n = Integer.parseInt(reader.readLine());
		System.out.println("n:" + n);
		float[] a = new float[n];
		String[] line = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Float.parseFloat(line[i]);
		}
		reader.close();

		sort(a, n);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				CreateInput.PATH_OUTPUT_FILE + "combsort.out"));
		DecimalFormat format = new DecimalFormat("0.00");
		for (int i = 0; i < n; i++) {
			writer.write(String.valueOf(format.format(a[i])));
			if (i != n - 1) {
				writer.write(" ");
			}
		}
		writer.close();
	}

	public static void sort(float[] a, int n) {
		int gap = n;
		float shrink = 1.3f;
		boolean sorted = false;

		while (gap > 1 || sorted == false) {
			// Update the gap value for a next comb
			gap = (int) (gap / shrink);
			System.out.println("gap:"+gap);
			if (gap < 1) {
				gap = 1;
			}
			int i = 0;
			if (gap == 1) {
				sorted = true;
			}

			// A single " comb " over the input list
			while (i + gap < n) {
				if (a[i] > a[i + gap]) {
					float temp = a[i];
					a[i] = a[i + gap];
					a[i + gap] = temp;
					if (gap == 1) {
						sorted = false;
					}
				}
				i++;
			}
		}
	}
}