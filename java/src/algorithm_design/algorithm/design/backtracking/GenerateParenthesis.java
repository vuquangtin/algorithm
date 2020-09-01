package algorithm.design.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses. For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class GenerateParenthesis {
	public static void main(String[] args) {
		List<String> list = new GenerateParenthesis().generateParenthesis(3);
		System.out.println(list);
	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new LinkedList<>();
		backtrack(res, "", n, n);
		return res;
	}

	private void backtrack(List<String> res, String parenthesis, int left,
			int right) {
		if (left > right) {
			return;
		} else if (left == 0 && right == 0) {
			res.add(parenthesis);
		} else {
			backtrack(res, parenthesis + ")", left, right - 1);
			if (left > 0) {
				backtrack(res, parenthesis + "(", left - 1, right);
			}
		}
	}
}