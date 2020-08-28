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
public class Util {
	public static int findMaxValueIndex(SortArray array, int upToIndex) {
		int maxIndex = 0;
		for (int i = 0; i < upToIndex; i++) {
			if (array.getValue(i) > array.getValue(maxIndex)) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}