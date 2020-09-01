package algorithm.design.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
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

public class Permutations {
	/**
	 * 全排列函数
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		helper(nums, result, path);
		return result;
	}

	/**
	 * DFS深度优先搜索，搜索停止的依据是路径的长度等于原始数据集合的长度
	 * 
	 * @param nums
	 * @param result
	 * @param path
	 */
	public void helper(int[] nums, List<List<Integer>> result,
			List<Integer> path) {
		if (nums.length == path.size()) {
			result.add(new ArrayList<>(path));
			return;
		}
		// 如果path的长度还不等于nums的长度，说明排列还没有完成，
		// 要继续遍历剩下的元素，加入到path中，下一个元素不能和已有path中的元素重合
		boolean isVisited = false;
		for (int i = 0; i < nums.length; ++i) {
			isVisited = find(nums[i], path);
			if (!isVisited) {
				path.add(nums[i]);
				helper(nums, result, path);
				path.remove(path.size() - 1);
			}
		}
	}

	/**
	 * 判断当前元素是否已经存在于path中
	 * 
	 * @param target
	 * @param path
	 * @return
	 */
	public boolean find(int target, List<Integer> path) {
		Iterator<Integer> pathIt = path.iterator();
		boolean result = false;
		while (pathIt.hasNext()) {
			Integer tmp = pathIt.next();
			if (tmp.intValue() == target) {
				result = true;
				break;
			}
		}
		return result;
	}
}