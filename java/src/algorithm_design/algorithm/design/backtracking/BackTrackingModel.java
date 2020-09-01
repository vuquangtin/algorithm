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
public class BackTrackingModel {
	int n = 8, k = 8;
	int[] x = new int[8];

	void backtrack(int t) {
		if (t > n)
			System.out.println("");
		else
			for (int i = 1; i <= k; ++i) {
				x[t] = value(i);
				if (constraint(t) && bound(t))
					backtrack(t + 1);
			}
	}

	void iterativeBacktrack() {
		int t = 1;
		while (t > 0) {
			if (ExistSubNode(t)) // 当前节点的存在子节点
			{
				for (int i = 1; i <= k; ++i) // 遍历当前节点的所有子节点
				{
					x[t] = value(i);// 每个子节点的值赋值给x
					if (constraint(t) && bound(t))// 满足约束条件和限界条件
					{
						// solution表示在节点t处得到了一个解
						if (solution(t))
							System.out.println("");// 得到问题的一个可行解，输出
						else
							t++;// 没有得到解，继续向下搜索
					}
				}
			} else // 不存在子节点，返回上一层
			{
				t--;
			}
		}
	}

	/**
	 * 约束条件函数，满足返回true，不满足则返回false
	 * 
	 * @param n
	 * @return
	 */
	boolean constraint(int n) {
		return true;
	}

	/**
	 * 边界条件函数，原理同上
	 * 
	 * @param n
	 * @return
	 */
	boolean bound(int n) {
		return true;
	}

	/**
	 * 得到节点n的值并返回
	 * 
	 * @param n
	 * @return
	 */
	int value(int n) {
		return n;
	}

	/**
	 * 在节点n得到了一个解
	 * 
	 * @param n
	 * @return
	 */
	boolean solution(int n) {
		return true;
	}

	/**
	 * 结点n是否存在子结点
	 * 
	 * @param n
	 * @return
	 */
	boolean ExistSubNode(int n) {
		return true;
	}
}