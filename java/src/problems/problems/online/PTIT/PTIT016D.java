package problems.online.PTIT;

import java.util.Arrays;
import java.util.Scanner;

/**
 * PTIT016D - ACM PTIT 2016 D - Biểu thức
 * 
 * Một dãy gồm n số nguyên không âm a1, a2,..., an được viết thành một hàng
 * ngang, giữa hai số liên tiếp có một khoảng trắng, như vậy có tất cả (n­-1)
 * khoảng trắng. Người ta muốn đặt k dấu cộng và (n-1-k) dấu trừ vào (n­-1)
 * khoảng trắng đó để nhận được một biểu thức có giá trị lớn nhất.
 * 
 * Ví dụ, với dãy gồm 5 số nguyên 28, 9, 5, 1, 69 và k = 2 thì cách đặt
 * 28+9-5-1+69 là biểu thức có giá trị lớn nhất.
 * 
 * Yêu cầu: Cho dãy gồm n số nguyên không âm a1, a2,..., an và số nguyên dương
 * k, hãy tìm cách đặt k dấu cộng và (n-1-k) dấu trừ vào (n­-1) khoảng trắng để
 * nhận được một biểu thức có giá trị lớn nhất. Input
 * 
 * - Dòng đầu chứa hai số nguyên dương n, k (k < n ≤ 105);
 * 
 * - Dòng thứ hai chứa n số nguyên không âm a1, a2,..., an (an ≤ 106) Output
 * 
 * - Một số nguyên là giá trị của biểu thức đạt được. Example
 * 
 * Input:
 * 
 * 5 2
 * 
 * 28 9 5 1 69
 * 
 * Output: 100
 * 
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class PTIT016D {
	/*-
	 * see https://github.com/duyhoangptit/Java-Common/tree/master/src/main/java/javaspoj
	 * 
	 * https://github.com/duyhoangptit/Java-Common/blob/master/src/main/java/javaspoj/note/PTIT016D.java
	 * 
	 * https://github.com/hoangtdvnext/JavaCore
	 * https://github.com/tienit150198/ACM
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		long[] a = new long[n];
		long[] b = new long[n - 1];
		a[0] = input.nextInt();
		for (int i = 1; i < n; i++) {
			a[i] = input.nextInt();
			b[i - 1] = a[i];
		}
		Arrays.sort(b);
		System.out.println(tinh(b, n, k, a[0]));
	}

	public static long tinh(long[] a, int n, int k, long kq) {
		k = n - k - 1;
		for (int i = 0; i < k; i++) {
			kq -= a[i];
		}
		for (int j = k; j < n - 1; j++) {
			kq += a[j];
		}
		return kq;
	}
}