package thuattoan.basic.stream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

 
public class PushbackReaderDemo {
 
    public static void main(String args[]) throws IOException {
        String s = "if (a == 4) a = 0;\\n";
        char buf[] = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        CharArrayReader in = new CharArrayReader(buf);
        PushbackReader f = new PushbackReader(in);
        int c;
        while ((c = f.read()) != -1) {
            switch (c) {
            // Tìm thấy ký tự '='
            case '=':
                // Đọc tiếp một ký tự nữa.
                // (Sau khi đã tìm thấy ký tự '=' trước đó).
                if ((c = f.read()) == '=') {
                    System.out.print(".eq.");
                }
 
                else {
                    System.out.print("<-");
                    // Đẩy trở lại (Pushes back) ký tự này lên luồng.
                    // Giống như lùi con trỏ trở lại 1 vị trí.
                    f.unread(c);
                }
                break;
            default:
                System.out.print((char) c);
                break;
            }
        }
    }
 
}