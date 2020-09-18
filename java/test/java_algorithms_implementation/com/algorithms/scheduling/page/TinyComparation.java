package com.algorithms.scheduling.page;

import java.util.Comparator;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class TinyComparation implements Comparator<Tiny> {

	@Override
	public int compare(Tiny a, Tiny b) {
		if (a.getI() < b.getI()) {
			return -1;
		} else if (a.getI() > b.getI()) {
			return 1;
		} else {
			return 0;
		}
	}

}