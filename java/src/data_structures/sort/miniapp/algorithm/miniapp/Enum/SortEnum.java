package algorithm.miniapp.Enum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import algorithm.miniapp.abstraction.SortMethod;
import algorithm.miniapp.sortalgorithms.bubblesort.BubbleSort;
import algorithm.miniapp.sortalgorithms.bucketsort.BucketSort;
import algorithm.miniapp.sortalgorithms.countingsort.CountingSort;
import algorithm.miniapp.sortalgorithms.heapsort.HeapSort;
import algorithm.miniapp.sortalgorithms.insertionsort.InsertionSort;
import algorithm.miniapp.sortalgorithms.jdksort.ArraysParallelSort;
import algorithm.miniapp.sortalgorithms.jdksort.ArraysSort;
import algorithm.miniapp.sortalgorithms.mergesort.MergeBuSort;
import algorithm.miniapp.sortalgorithms.mergesort.MergeOptimizedSort;
import algorithm.miniapp.sortalgorithms.mergesort.MergeSort;
import algorithm.miniapp.sortalgorithms.parallelsort.merge.ParallelMergeNwaySort;
import algorithm.miniapp.sortalgorithms.parallelsort.merge.ParallelMergeSort;
import algorithm.miniapp.sortalgorithms.parallelsort.quick.ParallelQuickSort;
import algorithm.miniapp.sortalgorithms.quicksort.DualPivotQuickSort;
import algorithm.miniapp.sortalgorithms.quicksort.Quick1ScanSort;
import algorithm.miniapp.sortalgorithms.quicksort.Quick3waySort;
import algorithm.miniapp.sortalgorithms.quicksort.QuickSort;
import algorithm.miniapp.sortalgorithms.radixsort.RadixSort;
import algorithm.miniapp.sortalgorithms.selectionsort.SelectionSort;
import algorithm.miniapp.sortalgorithms.shellsort.ShellSort;

/**
 * @author Tao
 */

public enum SortEnum {
    /**
     * 插入排序
     */
    InsertionSort("InsertionSort"),
    /**
     * 选择排序
     */
    SelectionSort("SelectionSort"),
    /**
     * 冒泡排序
     */
    BubbleSort("BubbleSort"),
    /**
     * 桶排序
     */
    BucketSort("BucketSort"),
    /**
     * 计数排序
     */
    CountingSort("CountingSort"),
    /**
     * 堆排序
     */
    HeapSort("HeapSort"),
    /**
     * 堆排序
     */
    RadixSort("RadixSort"),
    /**
     * 自下而上归并排序
     */
    MergeSort("MergeSort"),
    /**
     * 自下而上归并排序
     */
    MergeBuSort("MergeBuSort"),
    /**
     * 优化归并排序
     */
    MergeOptimizedSort("MergeOptimizedSort"),
    /**
     * 快速排序
     */
    QuickSort("QuickSort"),
    /**
     * 三向切分快速排序
     */
    Quick3waySort("Quick3waySort"),
    /**
     * 快速双轴排序
     */
    DualPivotQuickSort("DualPivotQuickSort"),
    /**
     * 希尔排序
     */
    ShellSort("ShellSort"),
    /**
     * Arrays排序
     */
    ArraysSort("ArraysSort"),
    /**
     * Arrays并行排序
     */
    ArraysParallelSort("ArraysParallelSort"),
    /**
     * 多线程快速排序
     */
    ParallelQuickSort("ParallelQuickSort"),
    /**
     * Arrays多线程归并排序
     */
    ParallelMergeSort("ParallelMergeSort"),
    /**
     * 多线程归并排序
     */
    ParallelMergeNwaySort("ParallelMergeNwaySort");

    private String name;
    private static Map<String,SortMethod> cache;

    static {
        Map<String,SortMethod> map = new HashMap<>(32);
        map.put("InsertionSort",            new InsertionSort());
        map.put("SelectionSort",            new SelectionSort());
        map.put("BubbleSort",               new BubbleSort());
        map.put("BucketSort",               new BucketSort());
        map.put("CountingSort",             new CountingSort());
        map.put("HeapSort",                 new HeapSort());
        map.put("RadixSort",                new RadixSort());
        map.put("MergeSort",                new MergeSort());
        map.put("MergeBuSort",              new MergeBuSort());
        map.put("MergeOptimizedSort",       new MergeOptimizedSort());
        map.put("QuickSort",                new QuickSort());
        map.put("Quick1ScanSort",           new Quick1ScanSort());
        map.put("Quick3waySort",            new Quick3waySort());
        map.put("DualPivotQuickSort",       new DualPivotQuickSort());
        map.put("ShellSort",                new ShellSort());
        map.put("ArraysSort",               new ArraysSort());
        map.put("ArraysParallelSort",       new ArraysParallelSort());
        map.put("ParallelQuickSort",        new ParallelQuickSort());
        map.put("ParallelMergeSort",        new ParallelMergeSort());
        map.put("ParallelMergeNwaySort",    new ParallelMergeNwaySort());
        cache = Collections.unmodifiableMap(map);
    }

    SortEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SortMethod getSortMethod() {
        return cache.get(name);
    }

    public String getCnName() {
        return cache.get(name).getCnName();
    }

    @Override
    public String toString() {
        return "SortEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}
