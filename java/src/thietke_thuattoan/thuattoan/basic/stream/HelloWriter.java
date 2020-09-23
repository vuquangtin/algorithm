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
 
public class HelloWriter {
 
    public static void main(String[] args) throws IOException {
        File dir = new File("C:/test");
 
        // Tạo thư mục 'C:/test', nếu nó chưa tồn tại.
        dir.mkdirs();
 
        // Tạo một đối tượng Writer, để ghi dữ liệu vào file.
        // Với mã hóa (encoding) mặc định.
        Writer w = new FileWriter("C:/test/test_writer.txt");
 
        // Mảng các ký tự.
        char[] chars = new char[] { 'H', 'e', 'l', 'l', 'o', // 
                ' ', 'w', 'r', 'i', 't', 'e', 'r' };
 
        // Ghi lần lượt các ký tự vào luồng (stream).
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int j = (int) ch;
            // 
            w.write(j);
        }
        // Đóng luồng (Close stream),
        w.close();
    }
}
