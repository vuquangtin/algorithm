package com.algorithms.sorts;

/**
 * 
 * Cài đặt thuật toán sắp xếp chọn
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SelectionSort {

	static int list[] = { 1, 4, 7, 2, 5, 2, 9, 11 };

	public static void selectionSort(int list[]) {
		for (int i = 0; i < list.length - 1; i++) {
			/* Find the minimum in the list[i..list.length-1] */
			int currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			/* Swap list[i] with list[currentMinIndex] if necessary */
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	public static void main(String[] args) {
		selectionSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "\t");
		}
	}
}