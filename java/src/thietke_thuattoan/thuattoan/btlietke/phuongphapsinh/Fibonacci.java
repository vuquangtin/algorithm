package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class Fibonacci {
	int runTapulation() {
		fn = 0;
		f0 = 1;
		f1 = 1;
		for (int i = 2; i <= n; i++) {

			fn = f0 + f1;
			System.out.println("f0+f1=" + f0 + "+" + f1 + "=" + fn);
			f0 = f1;
			f1 = fn;
		}
		return fn;
	}
	int runMemoization(){
		return runMemoization(n);
	}
	int runMemoization(int n) // Memory table :F[i] fibonacci number ith
	{ // Top-down
		// overlapping
		// lenh if kiem tra va tranh lap lai fibonacci(n-2) overlapping
		if (n <= 1) // De quy
		{
			return 1;
		}
		// goi de quy n-1th and n-2th
		fn = runMemoization(n - 1) + runMemoization(n - 2);
		return fn;
	}

	private int n;

	private int fn, f1, f0;

	void nhap() {
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter nth Fibonacci :");
			n = input.nextInt();
		} while (n <= 0);

	}

	void xuat() {
		System.out.println(fn);
	}

	void xuat(int n) {
		System.out.println(n);
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();

		fib.nhap();
		int result = fib.runMemoization();
		fib.xuat(result);
		result = fib.runTapulation();
		fib.xuat(result);
		// fib.xuat(result);

	}
}
