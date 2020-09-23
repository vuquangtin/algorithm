package thuattoan.basic.stream;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HelloWriter2 {

	public static void main(String[] args) throws IOException {

		File dir = new File("C:/test");
		// Tạo thư mục 'C:/test' nếu nó chưa tồn tại.
		dir.mkdirs();

		// Tạo một đối tượng Writer, để ghi dữ liệu vào file.
		Writer w = new FileWriter("C:/test/test_writer2.txt");

		//
		char[] chars = new char[] { 'H', 'e', 'l', 'l', 'o', //
				' ', 'w', 'r', 'i', 't', 'e', 'r' };

		// Ghi tất cả các ký tự trong mảng vào luồng.
		w.write(chars);

		// Thông thường Java sử dụng bộ đệm (buffer)
		// để lưu trữ dữ liệu một cách tạm thời.
		// Khi bộ đệm (buffer) đầy, dữ liệu sẽ được đẩy (flush) xuống file.
		// Bạn cũng có thể chủ động đẩy (flush) dữ liệu xuống file.
		w.flush();

		// Ghi ký tự xuống dòng (new line character) vào luồng.
		w.write('\n');

		String s = "FileWriter";

		// Ghi một chuỗi vào luồng (stream).
		w.write(s);

		// Đóng luồng (Close stream).
		// Nó sẽ đẩy các dữ liệu trên bộ đệm (buffer) vào file.
		// Đồng thời kết thúc việc ghi dữ liệu.
		w.close();
	}
}