package thuattoan.basic.stream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class HelloInputStream {

	public static void main(String[] args) {
		try {

			// Tạo một đối tượng InputStream theo class con của nó.
			// Đây là luồng đọc một file.
			InputStream is = new FileInputStream("data.txt");

			int i = -1;

			// Đọc lần lượt các byte trong luồng.
			// Mỗi lần đọc ra 8bit, chuyển nó thành số int.
			// Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.

			while ((i = is.read()) != -1) {
				System.out.println(i + "  " + (char) i);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}