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

public class HelloReader {

	public static void main(String[] args) throws IOException {
		// Tạo một Reader (Luồng ký tự), để đọc một file.
		// Với mã hóa (encoding) mặc định.
		Reader r = new FileReader("test_reader.txt");
		int i = -1;

		// Đọc lần lượt từng ký tự trong luồng.
		while ((i = r.read()) != -1) {
			// Ép về (cast) thành kiểu ký tự.
			System.out.println((char) i);
		}
		r.close();
	}

}