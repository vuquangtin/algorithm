package thuattoan.basic.stream;
import java.io.BufferedReader;
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

public class BufferedReaderExample {
 
    public static void main(String[] args) throws IOException {
 
        InputStream in = new FileInputStream("test_multi_lines.txt");
        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
 
        String s = null;
        int i = 0;
 
        // Đọc từng dòng (line) dữ liệu.
        // Nếu đọc được null nghĩa là kết thúc Stream.
        while ((s = br.readLine()) != null) {
            i++;
            System.out.println(i + " : " + s);
        }
        br.close();
    }
 
}