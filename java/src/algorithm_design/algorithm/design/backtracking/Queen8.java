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
public class Queen8 {

	int[] a = new int[9];
	int n = 8, count = 0;

	/**
	 * 位置冲突算法，i表示在棋盘的第i列，a[i]表示在第i列中棋子摆在哪一行
	 * 所遵循的核心规律是：当(a[i]-a[j])/(i-j)=±1时，皇后之间会产生冲突
	 * 具体方法是：从第二列开始，以本列和其它的几列分别比较，看是否产生冲突。以此种方法检测任意两列是否存在冲突
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	boolean Chongtu(int a[], int n)// a[]位置数组，n皇后个数
	{
		int i = 0, j = 0;

		for (i = 2; i <= n; ++i)
			// i：位置
			for (j = 1; j <= i - 1; ++j)
				// j：位置
				if ((a[i] == a[j]) || (Math.abs(a[i] - a[j]) == i - j))// 1：在一行；2：在对角线上
					return false; // 冲突
		return true;// 不冲突
	}

	/**
	 * 八皇后问题：回溯算法（递归版） 函数参数代表递归摆放第几个皇后
	 * 
	 * @param k
	 */
	void Queens8(int k)// 参数k：递归摆放第k个皇后
	{
		int i = 0;

		if (k > n)// k>n：即k>8表示最后一个皇后摆放完毕
		{
			++count;
			System.out.println("第" + count + "种情况：");
			for (i = 1; i <= n; ++i)
				System.out.println(a[i]);// 打印情况
			System.out.println("\n");
		} else// 8个皇后未全部摆放完毕
		{
			for (i = 1; i <= n; ++i)// 摆放第k个皇后时（转下一行）
			{ // 依次从列顶端开始搜索，一直到列底端，直到找到合适位置,如果未找到，自动返回上层递归(回溯)
				a[k] = i;
				if (Chongtu(a, k))// 不冲突
					Queens8(k + 1);// 递归摆放下一个皇后
			}
		}
		return;
	}

	public static void main(String[] args) {
		Queen8 test = new Queen8();
		test.Queens8(1);// 参数1：表示摆放第1个皇后
	}
}