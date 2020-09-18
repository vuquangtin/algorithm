package com.algorithms.sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Minh hoạ thuật toán sắp xếp nổi bọt
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class BubbleSortByStep {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size:");
		int size = sc.nextInt();
		int[] list = new int[size];
		System.out.println("Enter " + size + " value: ");
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}

		System.out.println("Your list: ");
		System.out.println(Arrays.toString(list));
		System.out.println("After bubble sort: ");
		bubbleSortByStep(list);
	}

	public static void bubbleSortByStep(int[] list) {
		boolean needNextPass = true;
		for (int i = 1; i < list.length && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < list.length - i; j++) {
				if (list[j] > list[j + 1]) {
					System.out.println("We wiill swap " + list[j] + " with "
							+ list[j + 1]);
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					needNextPass = true;
				}
			}

			if (!needNextPass) {
				System.out
						.println("Array may be sorted and next pass not needed");
				break;
			}
			System.out.println("List after the " + i + " sort: ");
			System.out.println(Arrays.toString(list));
		}
		System.out.println();
	}
}