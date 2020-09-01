package algorithm.design.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Combinations {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (k == 0 || n == 0) {
			return result;
		}
		dfs(1, 0, n, k);
		return result;
	}

	public void dfs(int start, int listSize, int n, int k) {
		if (listSize == k) {
			result.add(new ArrayList<>(list));
			// 这里要注意！！！不能只将list传入，因为那只是个引用，在递归的情况下，每一次递归都会开辟新的空间，引用都废了
			return;
		}
		for (int i = start; i <= n; ++i) {
			list.add(i);
			dfs(++start, listSize + 1, n, k);
			list.remove(list.size() - 1);
			// 这里要注意！！！remove()方法的用法，参数如果是int型则默认删除index对应的元素，而不是值为参数的元素
		}
	}
}