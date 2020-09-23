package thuattoan.basic.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class OutputStreamExample2 {

	public static void main(String[] args) {
		try {
			//File dir = new File("C:/Test");
			// Tao thu muc C:/Test
			//dir.mkdirs();

			// Tạo một luồng nhị phân đầu ra với mục đích ghi thông tin vào file
			OutputStream os = new FileOutputStream(
					"test_writerOutputStream.txt");

			// Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
			byte[] by = new byte[] { 'H', 'e', 'l', 'l', 'o', ' ', 31, 34, 92 };
			byte[] by2 = new byte[] { 'H', 'e', 'l', 'l', 'o', ' ', 'b', 'o',
					'y' };

			// Ghi cả các byte trong mảng byte[] by vào luồng
			os.write(by);

			// Đẩy các byte hiện có trên luồng xuống file .
			os.flush();

			// Tiếp tục ghi các byte trong mảng thứ 2 vào luồng
			os.write(by2);

			// Đóng luồng vào công việc ghi thành công .
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}