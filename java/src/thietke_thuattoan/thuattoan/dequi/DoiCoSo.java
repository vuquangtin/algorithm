package thuattoan.dequi;

/**
 * https://github.com/lamtt2403/KTLTHDT/blob/master/tailieu/Tailieu/Tailieu/DATA-STRUCTURE-IN-JAVA/CHUONG%20II.%20MOT%20SO%20LUOC%20DO%20THUAT%20TOAN/Thuat-toan-dequi/DoiCoSo/src/doicoso/DoiCoSo.java
 * Đổi số tự nhiên n thành số hệ cơ số b (b<10)
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class DoiCoSo {
	private static int x, b;

	private static int Change_Radix(int x, int b) {
		if (x == 0)
			return (0);
		else
			return (x % b + 10 * Change_Radix(x / b, b));
	}

	public static void main(String[] args) {
		System.out.println("Kết quả:" + Change_Radix(13, 2));
		System.out.println("Kết quả:" + Change_Radix(15, 3));
		System.out.println("Kết quả:" + Change_Radix(23, 8));
	}
}