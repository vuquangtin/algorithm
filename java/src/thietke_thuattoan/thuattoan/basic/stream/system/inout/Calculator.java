package thuattoan.basic.stream.system.inout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Calculator {

	/**
	 * 
	 * @param This
	 *            program the user chooses an operation for two numbers such as
	 *            addition, subtraction, multiplication, divide, root, residue
	 *            and power
	 * @return
	 */

	public static int option, operator, number1, number2, base, exponent,
			result;
	public static float result2;

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		printMenu();
		questionOpcion();
		while (option < 8) {
			questionOperators();
			switch (option) {
			case 1:
				sum(number1, number2);
				break;
			case 2:
				substraction(number1, number2);
				break;
			case 3:
				multiplication(number1, number2);
				break;
			case 4:
				division(number1, number2);
				break;
			case 5:
				residue(number1, number2);
				break;
			case 6:
				root(operator);
				break;
			case 7:
				power(base, exponent);
				break;

			default:
				bw.write("Option invalided");
				bw.flush();
				break;
			}
			bw.write(" ");
			bw.flush();
			printMenu();
			questionOpcion();
		}
		bw.write("End the aplication");
		bw.flush();

	}

	private static void power(int base, int exponent) throws IOException {
		result2 = (float) Math.pow(base, exponent);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("The power of base " + base + " and exponent " + exponent
				+ " is " + result2 + "\n");
		bw.flush();
	}

	private static void root(int operator) throws IOException {
		result2 = (float) (Math.sqrt(operator));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("The root of " + operator + " is " + result2 + "\n");
		bw.flush();
	}

	private static void residue(int number1, int number2) throws IOException {
		result2 = (number1 % number2);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("The residue of " + number1 + " residue " + number2 + " is "
				+ result2 + "\n");
		bw.flush();
	}

	private static void division(int number1, int number2) throws IOException {
		result2 = (number1 / number2);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("The division of " + number1 + " divided " + number2 + " is "
				+ result2 + "\n");
		bw.flush();
	}

	private static void multiplication(int number1, int number2)
			throws IOException {

		result = number1 * number2;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("The multiplication of " + number1 + " multiplied " + number2
				+ " is " + result + "\n");
		bw.flush();
	}

	private static void substraction(int number1, int number2)
			throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		result = number1 - number2;
		bw.write("The substraction of " + number1 + " less " + number2 + " is "
				+ result + "\n");
		bw.flush();

	}

	private static void sum(int number1, int number2) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		result = number1 + number2;
		bw.write("The sum of " + number1 + " plus " + number2 + " is " + result
				+ "\n");
		bw.flush();
	}

	private static void questionOperators() throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		if (option == 6) {
			bw.write("Select the operator:  \n");
			bw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			operator = Integer.parseInt(br.readLine());

		} else {

			if (option == 7) {
				bw.write("Type the base:  \n");
				bw.flush();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				base = Integer.parseInt(br.readLine());

				bw.write("Type the exponent:  \n");
				bw.flush();
				BufferedReader br1 = new BufferedReader(new InputStreamReader(
						System.in));
				exponent = Integer.parseInt(br1.readLine());

			} else {

				bw.write("Type the number 1:  \n");
				bw.flush();
				BufferedReader br2 = new BufferedReader(new InputStreamReader(
						System.in));
				number1 = Integer.parseInt(br2.readLine());

				bw.write("Type the number 2:  \n");
				bw.flush();
				BufferedReader br3 = new BufferedReader(new InputStreamReader(
						System.in));
				number2 = Integer.parseInt(br3.readLine());

			}
		}
	}

	private static void questionOpcion() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		option = Integer.parseInt(br.readLine());

	}

	private static void printMenu() throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		bw.write("Menu Options\n");
		bw.flush();
		bw.write("1. (+) Addition. \n");
		bw.flush();
		bw.write("2. (-) Substraction. \n");
		bw.flush();
		bw.write("3. (x) Multiplication.\n");
		bw.flush();
		bw.write("4. (/) Division.\n");
		bw.flush();
		bw.write("5. (%) Residue.\n");
		bw.flush();
		bw.write("6. (√x) Root. \n");
		bw.flush();
		bw.write("7. (x^2)Power. \n");
		bw.flush();
		bw.write("8. Exit. \n");
		bw.flush();
	}
}