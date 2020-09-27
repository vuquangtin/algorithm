package thuattoan.basic.stream.system.inout;

import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class FILE {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader InputStream = null;
		FileWriter OutputStream = null;

		int c;

		try {
			InputStream = new FileReader("fileINP.txt");
			OutputStream = new FileWriter("fileOUT.txt");
			Scanner scan = new Scanner(InputStream);
			PrintWriter output = new PrintWriter(OutputStream, true);

			c = scan.nextInt();
			output.print(" " + c);
			System.out.println(c);

			c = scan.nextInt();
			output.print(" " + c);
			System.out.println(c);

			c = scan.nextInt();
			output.print(" " + c);
			System.out.println(c);

			c = scan.nextInt();
			output.print(" " + c);
			System.out.println(c);

		} catch (Exception e) {
			System.out.println("Co loi nhap xuat file: " + e.toString());

		} finally {
			if (InputStream != null) {
				InputStream.close();
				System.out.println("Doc thanh cong!");
			}
			if (OutputStream != null) {
				OutputStream.close();
				System.out.println("Ghi thanh cong!");
			}
		}
	}
}