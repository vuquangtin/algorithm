package algorithm.design.backtracking;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return true;

		boolean[][] map = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (exist(board, word, 0, i, j, map))
					return true;

		return false;
	}

	// location为检测字符串的位置，x和y分别是二维数组坐标，map为辅助boolean二维数组表示是否已经在此次检测中已经选中该字符
	public boolean exist(char[][] board, String word, int location, int x,
			int y, boolean[][] map) {
		char tmpChar = word.charAt(location);
		boolean result = false;
		location++;
		if (tmpChar != board[x][y])
			return false;
		else {
			map[x][y] = true;
			if (location == word.length())
				return true;
			if (x > 0 && !map[x - 1][y])
				result = result || exist(board, word, location, x - 1, y, map);
			if (x < board.length - 1 && !map[x + 1][y])
				result = result || exist(board, word, location, x + 1, y, map);
			if (y > 0 && !map[x][y - 1])
				result = result || exist(board, word, location, x, y - 1, map);
			if (y < board[0].length - 1 && !map[x][y + 1])
				result = result || exist(board, word, location, x, y + 1, map);
			if (!result)
				map[x][y] = false;
		}
		return result;
	}
}