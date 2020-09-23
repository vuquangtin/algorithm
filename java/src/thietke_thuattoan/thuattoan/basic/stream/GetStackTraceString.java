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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GetStackTraceString {

	private static String getStackTraceString(Exception e) {
		// Tạo một đối tượng ByteArrayOutputStream.
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// Những gì ghi vào 'printStream' sẽ được ghi sang 'baos'.
		PrintStream printStream = new PrintStream(baos);

		// Ghi thông tin lỗi sang 'printStream'
		e.printStackTrace(printStream);

		printStream.close();

		byte[] bytes = baos.toByteArray();

		String s = new String(bytes);
		return s;
	}

	public static void main(String[] args) {

		try {
			// Làm một điều gì đó trong khối try ...
			// Lỗi chia cho 0
			int i = 10 / 0;
		}
		// Có điều gì đó sai xót trong khi chạy khối try khối catch được chạy
		catch (Exception e) {
			// In ra lý do sai xót trong khi chạy
			System.out.println("Error on try..." + e.getMessage());
			// In ra thông tin quá trình chạy lỗi xuất hiện ở các vị trí nào ra
			// màn hình Console
			// Lấy được đoạn text "stack trace":
			String s = getStackTraceString(e);

			System.out.println("Stack Trace String " + s);
		}
	}
}