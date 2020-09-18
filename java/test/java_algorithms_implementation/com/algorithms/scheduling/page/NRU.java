package com.algorithms.scheduling.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class NRU implements PageReplacement {
	private HashMap<Integer, Integer> map;
	private LinkedHashMap<Integer, Integer> mapPage;
	private PriorityQueue<Tiny> queue;
	private String[][] table;
	private int errors;
	private String linePage;

	public NRU(int[] page, int frame) {
		map = new HashMap<>();
		mapPage = new LinkedHashMap<>();
		queue = new PriorityQueue<>(new TinyComparation());

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
				int max = Integer.MIN_VALUE;
				Tiny tinyMax = null;

				List<Tiny> list = new ArrayList<Tiny>(queue);
				list.sort(new TinyComparation());
				queue.clear();
				queue.addAll(list);

				for (Tiny iter : queue) {
					boolean flag = false;
					for (int j = i + 1; j < page.length; j++) {
						if (iter.getI() == page[j]) {
							flag = true;
							if (max < (j - i)) {
								max = j - i;
								tinyMax = iter;
							}
							break;
						}
					}

					if (!flag) {
						tinyMax = iter;
						break;
					}
				}

				queue.remove(tinyMax);
				queue.add(new Tiny(page[i], tinyMax.getPos()));
				map.remove(tinyMax.getI());
				map.put(page[i], page[i]);

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
		System.out.println("NRU Table replacement: ");

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