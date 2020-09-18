package ctdl.va.gt.create.examp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import algorithm.utilities.Resource;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CreateInput {
	public static final String PATH_OUTPUT_FILE = Resource.PATH_INPUT;
	// "/home/vuquangtin/workspace/java-algorithm/algorithm/java/src/resources/input/";

	public static void main(String[] args) throws IOException {
		// createIntRandom(500, 10000, false, "combsort.inp", "\n");
		createIntRandomInline(500, 10000, "combsort.inp", " ");
	}

	public static void createIntRandomInline(int numberOfInteger,
			int randomMax, String filename, String split) {
		createIntRandom(numberOfInteger, randomMax, true, filename, split);
	}

	public static void createIntRandom(int numberOfInteger, int randomMax,
			boolean appendCountLine, String filename, String split) {
		File file = new File(PATH_OUTPUT_FILE);
		file.mkdirs();
		boolean first = true;
		int randomOfInteger;
		try (PrintWriter writer = new PrintWriter(new FileWriter(
				PATH_OUTPUT_FILE + filename, false), true)) {
			if (appendCountLine)
				writer.println(numberOfInteger);
			Random random = new Random();
			for (int i = 0; i < numberOfInteger; i++) {
				randomOfInteger = random.nextInt(randomMax);
				if (!first)
					writer.print(split + randomOfInteger);
				else {
					first = false;
					writer.print("" + randomOfInteger);
				}
			}
			System.out.println("Done: ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void createStringRandom() {
		Scanner inp = new Scanner(System.in);
		for (int index = 1; index <= 10; index++) {
			// System.out.print("Nhập số phần tử: ");
			int numberOfInteger = 0;
			String path = PATH_OUTPUT_FILE;
			if (index != 10) {
				path += "0" + index;
			} else {
				path += index;
			}
			File file = new File(path);
			file.mkdirs();
			try (PrintWriter writer = new PrintWriter(new FileWriter(file
					+ "/ToiletSeat.inp", false), true)) {
				// writer.println(numberOfInteger);
				Random random = new Random();
				numberOfInteger = random.nextInt(1001);
				for (int i = 0; i < numberOfInteger; i++) {
					int x = random.nextInt(2);
					if (x == 0) {
						writer.print("U");
					} else {
						writer.print("D");
					}
				}
				System.out.println("Done: " + index);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		inp.close();
	}
}