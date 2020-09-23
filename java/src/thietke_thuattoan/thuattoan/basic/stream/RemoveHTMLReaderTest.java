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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
 
public class RemoveHTMLReaderTest {
 
    public static void main(String[] args) throws IOException {
 
        // Tạo một đối tượng Reader từ Constructor của StringReader.
        Reader in = new StringReader("<h1>Hello \n <b>World</b><h1>");
 
        RemoveHTMLReader filterReader = new RemoveHTMLReader(in);
        BufferedReader br = new BufferedReader(filterReader);
 
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    }
}