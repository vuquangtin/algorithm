package thuattoan.basic.stream;
import java.io.FilterReader;
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

 
public class RemoveHTMLReader extends FilterReader {
 
    boolean intag = false;
 
    public RemoveHTMLReader(Reader in) {
        super(in);
    }
 
    // Chúng ta ghi đè (override) phương thức này.
    // Nguyên tắc sẽ là:
    // Chỉ đọc các ký tự nằm ngoài các thẻ (tag).
    @Override
    public int read(char[] buf, int from, int len) throws IOException {
 
        int charCount = 0;
 
        while (charCount == 0) {
 
            charCount = super.read(buf, from, len);
            if (charCount == -1) {
                // Kết thúc stream.
                return -1;
            }
 
            int last = from;
 
            for (int i = from; i < from + charCount; i++) {
                // Nếu không nằm trong thẻ HTML.
                if (!intag) {
                    if (buf[i] == '<') {
                        intag = true;
                    } else {
                        buf[last++] = buf[i];
                    }
                } else if (buf[i] == '>') {
                    intag = false;
                }
            }
 
            charCount = last - from;
        }
        return charCount;
    }
 
    // Cũng cần ghi đè phương thức này.
    @Override
    public int read() throws IOException {
        char[] buf = new char[1];
        int result = read(buf, 0, 1);
        if (result == -1) {
            return -1;
        } else {
            return (int) buf[0];
        }
    }
}