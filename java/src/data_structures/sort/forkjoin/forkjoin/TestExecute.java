package forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import forkjoin.quicksort.DualPivotQuickRunTask;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class TestExecute {

	public static void main(String[] args) {
		long ss = System.currentTimeMillis();
		SortArray sort = new SortArray(100000000);
		int[] randomInt2 = sort.cloneData();
		int[] randomInt3 = sort.cloneData();
		long se = System.currentTimeMillis();
		System.out.println("O(n) times " + (se - ss) + "ms!");

		// 执行一个任务
		ForkJoinPool forkjoinPool = new ForkJoinPool();
		// MergeRunTask task = new MergeRunTask(sort);
		// MergeNwayRunTask task = new MergeNwayRunTask(sort,6);
		// QuickRunTask task = new QuickRunTask(sort);
		DualPivotQuickRunTask task = new DualPivotQuickRunTask(sort);

		System.out.println("start ----");

		long s1 = System.currentTimeMillis();
		ForkJoinTask submit = forkjoinPool.submit(task);
		long s2 = 0;
		try {
			submit.get();
			s2 = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("排序 ===== " + (sort.isSorted() ? "成功!" : "失败!"));

		long s3 = System.currentTimeMillis();
		Arrays.sort(randomInt2);
		long s4 = System.currentTimeMillis();

		long s5 = System.currentTimeMillis();
		Arrays.parallelSort(randomInt3);
		long s6 = System.currentTimeMillis();
		System.out.println("parallelSort ===== "
				+ (new SortArray(randomInt3).isSorted() ? "成功!" : "失败!"));

		// -Xmx16g -Xms16g
		// QuickRunTask 1000000000 fork join sort 28092ms!
		// Arrays sort 108991ms!
		// MergeRunTask 1000000000 fork join sort 50125ms!
		// Arrays sort 99199ms!
		System.out.println("fork join sort " + (s2 - s1) + "ms!");
		System.out.println("Arrays sort " + (s4 - s3) + "ms!");
		System.out.println("parallelSort sort " + (s6 - s5) + "ms!");

		// System.out.println(Arrays.toString(sort.getData()));

	}

}
