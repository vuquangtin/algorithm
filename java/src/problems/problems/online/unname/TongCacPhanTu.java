package problems.online.unname;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
public class TongCacPhanTu {
	int n;
	int total;
	int B[];
	int A[];
	int dem = 0;
	BufferedWriter bw;

	/*-
	 * Bài 2.Cho dãy A[] gồm N số tự nhiên khác nhau và số tự nhiên K. 
	 * Hãy sử dụng thuật toán sinh viết chương trình liệt kê tất cả các dãy con của dãy số A[] 
	 * sao cho tổng các phần tử trong dãy con đó đúng bằng K.
		Dayso.in                   Ketqua.out
		5 50                    3
		5 10 15 20 25          	10 15 25
                                5 20 25
                                5 10 15 20
	 */
	public void init() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(Resource.PATH_INPUT_UNNAME + "dayso.inp"));
			String line1 = br.readLine();
			String line2 = br.readLine();
			n = Integer.parseInt(line1.split("\\s+")[0]);
			total = Integer.parseInt(line1.split("\\s+")[1]);
			// System.out.println(line1);
			String[] lines = line2.split("\\s+");
			B = new int[n];
			for (int i = 0; i < n; i++) {
				B[i] = Integer.parseInt(lines[i]);
			}
			A = new int[n];
			for (int i = 1; i < n; i++) {
				A[i] = 0;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	boolean OK = true;

	void Next_Bit() {
		int i = n - 1;
		while (i >= 0 && A[i] != 0) {
			A[i] = 0;
			i--;
		}
		if (i >= 0) {
			A[i] = 1;
		} else
			OK = false;
	}

	void sovle() {
		while (OK) {
			Output();
			Next_Bit();
		}
		try {
			System.out.println(dem);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void Output() {
		int a = 0;
		for (int i = 0; i < n; i++) {
			a = a + B[i] * A[i];
		}
		if (a == total) {
			dem++;
			for (int i = 0; i < n; i++) {
				if (A[i] * B[i] != 0) {
					try {
						bw.write(B[i] + " ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		TongCacPhanTu t = new TongCacPhanTu();
		t.init();
		t.sovle();

	}

}
