package algorithm.design.DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem statement: Given two integers n and k, return all possible
 * combinations of k numbers out of 1 ... n. For example, If n = 4 and k = 2, a
 * solution is: [[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
 * 
 * Strategy: Determin the starting number `start` among all k numbers as a first
 * step. Afterwards, repeat the same problem by changing k to k-1 and changing
 * possible starting number from `start` to `start+1`
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
/*
*/
public class Combine {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<>();
		if (k > n)
			return res;
		helper(n, k, 1, new LinkedList<Integer>(), res);
		return res;
	}

	private void helper(int n, int k, int start, List<Integer> list,
			List<List<Integer>> res) {
		if (k == 1) {
			for (int i = start; i <= n; i++) {
				List<Integer> inner = new LinkedList<Integer>(list);
				inner.add(i);
				res.add(inner);
			}
			return;
		}
		for (int i = start; i <= n - k + 1; i++) {
			List<Integer> inner = new LinkedList<Integer>(list);
			inner.add(i);
			helper(n, k - 1, i + 1, inner, res);
		}
	}
}