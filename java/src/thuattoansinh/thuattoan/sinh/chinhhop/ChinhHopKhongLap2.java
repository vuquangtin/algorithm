package thuattoan.sinh.chinhhop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ChinhHopKhongLap2 {
	int a[] = new int[100];
	int n, k, per;

	int fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}

	int permutation(int n, int k) {
		return fact(n) / fact(n - k);
	}

	void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Nhap n: ");
		n = Integer.parseInt(br.readLine());
		System.out.print("Nhap k: ");
		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++)
			a[i] = i;

		count = 0;
		// per = permutation(n, k);
	}

	void out() {
		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + " ");
		}
		count++;
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void generate() {
		int p = k - 1;
		while (a[p] == n - (k - p))
			p--;

		a[p]++;

		for (int i = p ; i < k; i++) {
			a[i] = a[i - 1] + 1;
		}
	}

	void gen() {
		int i = k - 1;
		while (!(a[i] < a[i + 1]))
			i--;

		int j = k-1;
		while (!(a[j] > a[i]))
			j--;

		swap(i, j);

		int l = i + 1;
		int r = k-1;

		while (l < r) {
			swap(l, r);
			l++;
			r--;
		}

		out();
	}

	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	void method() throws NumberFormatException, IOException {
		init();
		out();
		generate();
		gen();
//
		while (count != per) {

			generate();
			gen();
		}
		System.out.print("So tap hop con co k phan tu: " + count);
	}

	static int count = 0;

	public static void main(String[] args) {

		ChinhHopKhongLap2 chinhhop = new ChinhHopKhongLap2();
		try {
			chinhhop.method();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
