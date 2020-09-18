package com.algorithms.scheduling.page;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * pagereplacement
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class FIFO implements PageReplacement {
	private HashMap<Integer, Integer> map;
	private Queue<Tiny> queue;
	private String[][] table;
	private int errors;
	private String linePage;

	public FIFO(int[] page, int frame) {
		map = new HashMap<>();
		queue = new LinkedList<>();
		table = new String[frame + 1][page.length + 1];
		errors = 0;

		for (int i = 0; i <= frame; i++) {
			for (int j = 0; j <= page.length; j++) {
				table[i][j] = "|   |";
			}
		}

		for (int i = 0; i < frame; i++) {
			table[i][0] = "|  F" + (i + 1) + "  :";
		}
		table[frame][0] = "|Fault :";

		process(page, frame);
	}

	private void process(int[] page, int frame) {
		for (int i = 0; i < page.length; i++) {
			if (queue.size() < frame) {
				queue.add(new Tiny(page[i], queue.size()));
				map.put(page[i], page[i]);
				table[frame][i + 1] = "| x |";
				errors++;
			} else if (!map.containsKey(page[i])) {
				Tiny tmp = queue.poll();
				map.remove(tmp.getI());
				map.put(page[i], page[i]);
				queue.add(new Tiny(page[i], tmp.getPos()));
				table[frame][i + 1] = "| x |";
				errors++;
			}

			for (Tiny iter : queue) {
				table[iter.getPos()][i + 1] = "| "
						+ Integer.toString(iter.getI()) + " |";
			}
		}

		linePage = "| Page :";
		for (int i = 0; i < page.length; i++) {
			linePage += "| " + page[i] + " |";
		}
	}

	@Override
	public void showTable() {
		System.out.println("FIFO Table replacement: ");

		int numChar = 5 * (table[0].length - 1) + 8;
		String line = "";

		for (int i = 0; i < numChar; i++) {
			line += "-";
		}

		System.out.println(line);
		System.out.println(linePage);
		System.out.println(line);

		for (String[] arr : table) {
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
			System.out.println(line);
		}

		System.out.println("Sum errors = " + errors + ".");
	}

}