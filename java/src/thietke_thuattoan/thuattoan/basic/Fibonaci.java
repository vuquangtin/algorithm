package thuattoan.basic;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Fibonaci {

	public String fibonaci(int n) {
		int f1 = 1;
		int f2 = 1;
		if (n <= 0) {
			return "So nhap khong phai so nguyen";
		}
		StringBuffer str = new StringBuffer();
		while (f1 <= n) {
			str.append(f1);
			int temp = f2;
			f2 += f1;
			f1 = temp;
			if (f1 <= n) {
				str.append(" ");
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		System.out.println(new Fibonaci().fibonaci(10));
	}
}