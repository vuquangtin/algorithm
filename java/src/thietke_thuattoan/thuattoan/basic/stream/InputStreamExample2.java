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


public class InputStreamExample2 {

	public static void main(String[] args) {
		try {
			// Tạo một luồng đầu vào bằng cách đọc một file
			InputStream in = new FileInputStream("data.txt");

			// Mảng để mỗi lần đọc các byte từ luồng thì tạm thời để lên đó
			// Ta dùng mảng 10 byte

			byte[] temp = new byte[10];
			int i = -1;

			// Đọc các byte trong luồng và gán lên các phần tử của mảng.
			// Giá trị i là số đọc được của 1 lần. (i sẽ <= 10).
			// Khi không còn phần tử trong luồng i sẽ = -1
			while ((i = in.read(temp)) != -1) {
				// Tạo String từ các byte đọc được
				String s = new String(temp, 0, i);
				System.out.println(s);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}