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
public class SelectionSort implements ISortAlgorithm {

	private long stepDelay = 120;

	/**
     */
	@Override
	public void runSort(SortArray array) {
		int len = array.arraySize();
		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (array.getValue(j) < array.getValue(minIndex)) {
					minIndex = j;
				}
			}
			array.swap(i, minIndex, getDelay(), true);
		}
	}

	@Override
	public String getName() {
		return "Selection Sort";
	}

	@Override
	public long getDelay() {
		return stepDelay;
	}

	@Override
	public void setDelay(long delay) {
		this.stepDelay = delay;
	}
}