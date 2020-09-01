package forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public abstract class AbstractRunTask extends RecursiveTask<SortArray> {

	/**
	 * 数组大小标准 如果小于这个数 就执行插入排序
	 */
	protected static final int threshold = 48;

	/**
	 * 数据项
	 */
	protected SortArray data;
	protected int l;
	protected int r;

	@Override
	protected abstract SortArray compute();
}
