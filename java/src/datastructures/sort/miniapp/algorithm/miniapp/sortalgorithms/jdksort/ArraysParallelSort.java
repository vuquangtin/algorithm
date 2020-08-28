package algorithm.miniapp.sortalgorithms.jdksort;

import java.util.Arrays;

import algorithm.miniapp.Enum.LineColorEnum;
import algorithm.miniapp.abstraction.SortMethod;

/**
 * @author Tao
 */
public class ArraysParallelSort implements SortMethod {

    @Override
    public String getCnName() {
        return "JDK 并行排序";
    }

    @Override
    public int[] sort(int[] arr) {
        Arrays.parallelSort(arr);
        return arr;
    }

    @Override
    public LineColorEnum lineColor() {
        return LineColorEnum.Tomato;
    }

    @Override
    public String methodName() {
        return "ArraysParallelSort";
    }

    @Override
    public void destory() {
    }
}
