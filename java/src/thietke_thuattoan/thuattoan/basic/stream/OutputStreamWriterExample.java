package thuattoan.basic.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class OutputStreamWriterExample {

	public static void main(String[] args) throws IOException {

		//File dir = new File("C:/test");
		// Tạo thư mục 'C:/test' nếu nó không tồn tại.
		//dir.mkdirs();
		// Tạo một OutputStream (luồng đầu ra) để ghi dữ liệu vào file.
		OutputStream out = new FileOutputStream("test_write_utf8.txt");

		// Tạo một Character Stream (luồng ghi ký tự) bao lấy OutputStream ở
		// trên.
		// Mã hóa (encoding) là UTF-8.
		Writer writer = new OutputStreamWriter(out, "UTF-8");

		String s = "JP日本-八洲";
		writer.write(s);
		writer.close();
	}

}