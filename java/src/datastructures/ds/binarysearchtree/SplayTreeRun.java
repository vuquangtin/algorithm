package binarysearchtree;

import java.util.Scanner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SplayTreeRun {

	public static void main(String[] args) {

		SplayTree<Integer> splayTree = new SplayTree<>();
		Scanner sc = new Scanner(System.in);
		int[] data = { 2, 29, 26, -1, 10, 0, 2, 11 };
		int c = 0;
		for (int i : data) {
			splayTree.insert(i);
		}

		while (c != 7) {
			System.out
					.println("1. Insert 2. Delete 3. Search 4.FindMin 5.FindMax 6. PrintTree 7. Exit");
			c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter Data :");
				splayTree.insert(sc.nextInt());
				break;
			case 2:
				System.out.println("Enter Element to be Deleted:");
				splayTree.delete(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter Element to be Searched and Splayed:");
				splayTree.search(sc.nextInt());
				break;
			case 4:
				System.out.println("Min: " + splayTree.findMin());
				break;
			case 5:
				System.out.println("Max: " + splayTree.findMax());
				break;
			case 6:
				System.out.println(splayTree);
				break;
			case 7:
				sc.close();
				break;
			}
		}
	}
}