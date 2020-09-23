package thuattoan.basic.stream.system.inout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import algorithm.utilities.Resource;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class FileInput {

	public void readFile(String fileName) throws IOException {

		FileReader fileReader = new FileReader(fileName); // initialize
															// FileReader for
															// fileName
		Scanner scan = new Scanner(fileReader);
		int count = 0;
		// this loop finds out how many lines are in file and sets them to count
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			System.out.println(line);
			count++;
		}
		fileReader.close(); // reset scanner and filereader
		scan.close();

	}

	public Scanner loadFile(String fileName) throws IOException {

		FileReader fileReader = new FileReader(fileName);
		Scanner scan = new Scanner(fileReader);

		fileReader.close(); // reset scanner and filereader
		// scan.close();
		return scan;

	}

	public static PrintWriter loadOutput(String OUT) throws IOException {

		return new FileInput().loadPrintWriter(OUT);
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

	/*-
	 * https://github.com/VikasSherawat/Programming/tree/master/CompanyInterviews
	 */
	public static BufferedReader loadInput(String IN) throws IOException {
		return new FileInput().loadBufferedReader(IN);
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

	public static void main(String[] args) {
		try {
			new FileInput().readFile("README.md");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedReader in = loadInput(Resource.PATH_INPUT + "read.inp");
			String[] size = in.readLine().split("\\s+");
			int N = Integer.parseInt(size[0]);
			int M = Integer.parseInt(size[1]);
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static final String IN = "input.inp";
	static final String OUT = "output.out";
	BufferedReader in;
	PrintWriter out;

	private void configOutput() {
		File file = new File(OUT);
		if (file.exists()) {
			file.delete();
		}
		try {
			out = new PrintWriter(new File(OUT));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void configInput() {
		// TODO Auto-generated method stub
		try {
			FileReader file = new FileReader(IN);
			in = new BufferedReader(file);
			// in = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = Integer.parseInt(in.readLine());
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.flush();
		out.close();
	}

	private void solve(int TURN) throws IOException {
		String[] size = in.readLine().split("\\s+");
		int N = Integer.parseInt(size[0]);
		int M = Integer.parseInt(size[1]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			int s = i + 10;
			int d = i * 10;
			sb.append("" + N + "" + M);
			sb.append(s + " " + "\n" + d);

		}

		fpl(sb.toString());
	}

	public void pl(Object inp) {
		System.out.println(inp);
	}

	public void p(Object inp) {
		System.out.print(inp);
	}

	public void fpl(Object inp) {
		out.println(inp);
	}

	public void fp(Object inp) {
		out.print(inp);
	}
}