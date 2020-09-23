package thuattoan.basic.stream;

import java.io.FilterWriter;
import java.io.IOException;
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

public class RotateWriter extends FilterWriter {

	public RotateWriter(Writer out) {
		super(out);
	}

	// Ghi đè một hoặc nhiều phương thức để sử lý việc lọc.
	// (Ghi đè cả 2 phương thức sẽ an toàn hơn).
	@Override
	public void write(int outChar) throws IOException {
		super.write(Rot13.rotate(outChar));
	}

	@Override
	public void write(char[] cbuf, int offset, int length) throws IOException {
		char[] tempbuf = new char[length];
		for (int i = 0; i < length; i++) {
			tempbuf[i] = (char) Rot13.rotate(cbuf[offset + i]);
		}
		super.write(tempbuf, 0, length);
	}

}