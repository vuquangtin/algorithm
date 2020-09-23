package thuattoan.basic.stream;

import java.io.IOException;
import java.io.StringWriter;
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

public class RotateWriterTest {

	public static void main(String[] args) throws IOException {
		String s = "abcdef";

		Writer writer = new StringWriter();

		RotateWriter rw = new RotateWriter(writer);
		rw.write(s.toCharArray(), 0, s.length());

		rw.close();

		String rotateString = writer.toString();
		System.out.println("rotateString=" + rotateString);
	}
}