package algorithm.docs.md.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ReadMe {
	private static final String README = "README.md";

	public static PrintWriter loadOutput() throws IOException {
		return loadOutput(README);
	}

	public static PrintWriter loadOutput(String OUT) throws IOException {
		return new ReadMe().loadPrintWriter(OUT);
	}

	private PrintWriter loadPrintWriter(String OUT) throws IOException {
		File file = new File(OUT);
		if (file.exists()) {
			file.delete();
		}
		try {
			PrintWriter out = new PrintWriter(new File(OUT));
			return out;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedReader loadInput() throws IOException {
		return loadInput(README);
	}

	public static BufferedReader loadInput(String IN) throws IOException {
		return new ReadMe().loadBufferedReader(IN);
	}

	private BufferedReader loadBufferedReader(String IN) throws IOException {
		try {
			FileReader file = new FileReader(IN);
			BufferedReader in = new BufferedReader(file);
			// in = new BufferedReader(new InputStreamReader(System.in));
			return in;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
