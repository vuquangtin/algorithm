package algorithm.sortvisualiser.gui.algorithms;

import algorithm.sortvisualiser.gui.SortArray;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public interface ISortAlgorithm {
	public String getName();

	public long getDelay();

	public void setDelay(long delay);

	public void runSort(SortArray array);
}