package thuattoan.basic.stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

// Ví dụ này sẽ đọc nhiều ký tự trong một lần.
public class HelloReader2 {

	public static void main(String[] args) throws IOException {

		// Tạo một đối tượng Reader đọc một file.
		// Với mã hóa (encoding) mặc định.
		Reader r = new FileReader("test_reader.txt");
		// Tạo một mảng tạm.
		char[] temp = new char[10];
		int i = -1;

		// Phương thức read(char[]):
		// Đọc nhiều ký tự trong một lần, và gán vào các phần tử của mảng.
		// Trả về số ký tự đọc được.
		// Trả về -1 nếu luồng (stream) kết thúc.
		while ((i = r.read(temp)) != -1) {
			String s = new String(temp, 0, i);
			System.out.println(s);
		}
		r.close();
	}

}