package com.algorithms.scheduling.page;

import java.util.Comparator;

/**
 * scheduling
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ComparatorBurstTime implements Comparator<Process>{

	@Override
	public int compare(Process a, Process b) {
		if (a.getBurstTime()>b.getBurstTime()) {
			return 1;
		}
		else if (a.getBurstTime()<b.getBurstTime()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}