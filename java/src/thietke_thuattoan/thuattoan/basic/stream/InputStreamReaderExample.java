package thuattoan.basic.stream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

 
public class InputStreamReaderExample {
 
    public static void main(String[] args) throws IOException {
 
        // Tạo một binary Stream (luồng nhị phân), để đọc file.
        InputStream in = new FileInputStream("test_utf8.txt");
 
        // Tạo một Character stream (luồng ký tự) bao lấy (wrap) luồng nhị phân trên.
        // Với mã hóa (encoding) là UTF-8.
        Reader reader = new InputStreamReader(in, "UTF-8");
 
        int i = 0;
        // Đọc lần lượt từng ký tự.
        while ((i = reader.read()) != -1) {
            // Ép kiểu (cast) thành một ký tự và in ra màn hình.
            System.out.println((char) i + " " + i);
        }
        reader.close();
    }
}