package thuattoan.cses.Dynamic_Programming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CoinCombinationsI {
	// https://github.com/PranayChauhan2516/ImpCodes/blob/master/CSES%20Problemset/Dynamic%20Programming/CoinCombinationsI.java
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastReader in = new FastReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		CoinCombinationsISolution solver = new CoinCombinationsISolution();
		solver.solve(1, in, out);
		out.close();
	}

	static class CoinCombinationsISolution {
		public void solve(int testNumber, FastReader in, PrintWriter out) {
			int n = in.nextInt(), x = in.nextInt(), a[] = in.readIntArray(n), dp[] = new int[x + 1], mod = (int) 1e9 + 7;
			dp[0] = 1;
			for (int i = 0; i <= x; ++i) {
				for (int coin_value : a) {
					if (coin_value <= i) {
						dp[i] = (dp[i] + dp[i - coin_value]) % mod;
					}
				}
			}
			out.println(dp[x]);
		}

	}

	static class FastReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private FastReader.SpaceCharFilter filter;

		public FastReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public int[] readIntArray(int size) {
			int[] array = new int[(int) size];
			for (int i = 0; i < size; i++)
				array[i] = nextInt();
			return array;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);

		}

	}
}