package thuattoan.basic.stream.system.inout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */

public class JavaInputStreamReaderEx {
	/*-
	 * http://zetcode.com/java/inputstreamreader/
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String fileName = "src/main/resources/russiantext.txt";

		try (FileInputStream fis = new FileInputStream(fileName);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr)) {

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
