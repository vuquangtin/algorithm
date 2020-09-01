package algorithm.design.backtracking.gui.nqueen;

import java.awt.Dimension;
import java.util.Vector;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Queens {

	static Vector<Dimension> position = new Vector<Dimension>();

	static boolean isSafe(int board[][], int row, int col) {

		int i, j;

		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < MainFrame.N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	static boolean solve(int board[][], int col) {

		if (col >= MainFrame.N)
			return true;

		for (int i = 0; i < MainFrame.N; i++) {

			if (isSafe(board, i, col)) {

				board[i][col] = 1;

				if (solve(board, col + 1) == true)
					return true;

				board[i][col] = 0;
			}
		}
		return false;
	}

	static void solve() {

		int board[][] = new int[MainFrame.N][MainFrame.N];
		position.clear();

		solve(board, 0);

		for (int i = 0; i < MainFrame.N; i++)
			for (int j = 0; j < MainFrame.N; j++)
				if (board[i][j] == 1)
					position.addElement(new Dimension(i, j));
	}
}