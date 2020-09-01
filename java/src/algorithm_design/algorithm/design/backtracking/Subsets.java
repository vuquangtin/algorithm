package algorithm.design.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		result.add(list);
		dfs(nums, 0, list, result);
		return result;
	}

	public void dfs(int[] nums, int start, List<Integer> list,
			List<List<Integer>> result) {
		if (start == nums.length) {
			return;
		}
		for (int i = start; i < nums.length; ++i) {
			list.add(nums[i]);
			result.add(new ArrayList<>(list));
			dfs(nums, ++start, list, result);
			list.remove(list.size() - 1);
		}
	}
}