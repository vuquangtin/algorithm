package thuattoan.sinh.chinhhop.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ChinhHopDeQuy {
	static void DatMacDinh(int a[], boolean b[], int n) {
		for (int i = 0; i <= n; i++) {
			a[i] = 0;
			b[i] = true;
		}
	}

	static void InCauHinh(int a[], int k) {
		for (int i = 0; i < k; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}

	static void XuLy(int a[], boolean b[], int n, int k, int i) {
		for (int j = 1; j <= n; j++) // Duyet tat ca cac truong hop tu 1 toi n
		{
			if (b[j] == true) // Neu do la phan tu chua bi trung
			{
				a[i] = j;
				if (i == k - 1) // Neu duyet het k phan tu thi in ra
				{
					InCauHinh(a, k);
				} else {
					b[j] = false; // Danh dau phan tu da duoc su dung
					XuLy(a, b, n, k, i + 1);
					b[j] = true; // Bo danh dau
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int[] a = new int[100];
		boolean[] b = new boolean[100]; // Kiểm tra xem có phải phần tử tự do
		int n, k;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("NHAP N: ");
		n = Integer.parseInt(br.readLine());
		System.out.print("NHAP K: ");
		k = Integer.parseInt(br.readLine());
		;
		DatMacDinh(a, b, n);
		XuLy(a, b, n, k, 0);

	}
}
