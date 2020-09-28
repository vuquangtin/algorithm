package thuattoan.test;

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
public class TongHop {
	public static final int MAX = 100;
	int[] a = new int[MAX];
	boolean[] b = new boolean[MAX];
	int n = 0;
	int k = 0;

	void inKq(int size) {
		for (int i = 1; i <= size; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}

	void khoiTao() {
		for (int i = 0; i <= n; i++)
			b[i] = true;
	}

	void taoHoanVi(int i) {
		for (int j = 1; j <= n; j++) {
			if (b[j]) {
				a[i] = j;
				if (i == n) {
					inKq(n);
				} else {
					b[j] = false;
					taoHoanVi(i + 1);
					b[j] = true;
				}
			}
		}
	}

	void taoChinhHop(int i) {
		for (int j = 1; j <= n; j++) {
			if (b[j]) {
				a[i] = j;
				if (i == k + 1)
					inKq(k);
				else {
					b[j] = false;
					taoChinhHop(i + 1);
					b[j] = true;
				}
			}
		}
	}

	void taoChinhHopLap(int i) {
		if (i == k + 1) {
			inKq(k);
			return;
		}

		for (int j = 1; j <= n; j++) {
			a[i] = j;
			taoChinhHopLap(i + 1);
		}
	}

	void taoToHop(int i) {
		for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
			a[i] = j;
			if (i == k) {
				inKq(k);
			} else
				taoToHop(i + 1);
		}
	}

	void taoToHopLap(int i) {
		for (int j = a[i - 1]; j <= n; j++) {
			a[i] = j;
			if (i == k) {
				inKq(k);
			} else
				taoToHopLap(i + 1);
		}
	}

	int tongMang(int size) {
		int tong = 0;

		for (int i = 1; i <= size; i++)
			tong += a[i];

		return tong;
	}

	void InKq(int size) {
		System.out.print(a[1]);
		for (int i = 2; i <= size; i++)
			System.out.print(" + " + a[i]);
		System.out.println(" = " + k);
	}

	void InKQ(int size) {
		System.out.print(a[1]);
		for (int i = 2; i <= size; i++)
			System.out.print(" + " + a[i]);
		System.out.println(" <= " + k);
	}

	void giaiPhuongTrinhNghiemNguyen(int i) {
		if (i == n + 1) {
			if (tongMang(n) == k) {
				InKq(n);
			}
			return;
		}

		for (int j = 0; j <= k; j++) {
			a[i] = j;
			giaiPhuongTrinhNghiemNguyen(i + 1);
		}
	}

	void giaiBatPhuongTrinhNghiemNguyen(int i) {
		if (i == n + 2) {
			if (tongMang(n + 1) == k) {
				InKQ(n);
			}
			return;
		}

		for (int j = 0; j <= k; j++) {
			a[i] = j;
			giaiBatPhuongTrinhNghiemNguyen(i + 1);
		}
	}

	boolean cauA() {
		for (int i = 1; i <= n - 2; i++)
			if (a[i] == 0 && a[i + 1] == 0)
				return false;
		return true;
	}

	boolean cauB() {
		for (int i = 1; i <= n - 1; i++)
			if (a[i] == 1 && a[i + 1] == 1)
				return true;
		return false;
	}

	void sinhNhiPhan(int i, boolean dieuKien) {
		if (i == n + 1) {
			if (dieuKien == true)
				inKq(n);
			return;
		}

		a[i] = 0;
		sinhNhiPhan(i + 1, dieuKien);

		a[i] = 1;
		sinhNhiPhan(i + 1, dieuKien);
	}

	int run() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Nhap n = ");
		n = Integer.parseInt(br.readLine());
		System.out.print("Nhap k = ");
		k = Integer.parseInt(br.readLine());

		System.out.println("Tat cua hoan vi cua " + n + " phan tu:");
		khoiTao();
		taoHoanVi(1);
		System.out.println("\n");

		System.out.println("Liet ke tat ca chinh hop chap " + " cua " + n);
		khoiTao();
		taoChinhHop(1);
		System.out.println("\n");

		System.out.println("Liet ke tat ca chinh hop lap chap " + k + " cua "
				+ n);
		taoChinhHopLap(1);
		System.out.println("\n");

		System.out.println("Liet ke tat ca to hop chap " + k + " cua " + n);
		a[0] = 0;
		taoToHop(1);
		System.out.println("\n");

		System.out.println("Liet ke tat ca to hop lap chap " + k + " cua " + n);
		a[0] = 1;
		taoToHopLap(1);
		System.out.println();

		System.out
				.println("Liet ke tat ca bo so x1, x2,..., xn thoa x1 + x2 + ... + xn = k");
		System.out.print("Nhap n = ");
		n = Integer.parseInt(br.readLine());
		System.out.print("Nhap k = ");
		k = Integer.parseInt(br.readLine());
		giaiPhuongTrinhNghiemNguyen(1);
		System.out.println("\n");

		System.out
				.println("Liet ke tat ca bo so x1, x2,..., xn thoa x1 + x2 + ... + xn <= k");
		System.out.print("Nhap n = ");
		n = Integer.parseInt(br.readLine());
		System.out.print("Nhap k = ");
		k = Integer.parseInt(br.readLine());
		giaiBatPhuongTrinhNghiemNguyen(1);
		System.out.println("\n");

		System.out.print("Nhap do dai cua day nhi phan n = ");
		n = Integer.parseInt(br.readLine());
		System.out.println("Chuoi nhi phan co do dai " + n
				+ " khong chua 2 bit 0 lien tiep:");
		sinhNhiPhan(1, cauA());
		System.out.println("\n");

		System.out.print("Nhap do dai cua day nhi phan n = ");
		n = Integer.parseInt(br.readLine());
		System.out.println("Chuoi nhi phan co do dai " + n
				+ " chua 2 bit 1 lien tiep:");
		sinhNhiPhan(1, cauB());

		return 0;
	}

	public static void main(String[] args) {
		TongHop t = new TongHop();
		try {
			t.run();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
