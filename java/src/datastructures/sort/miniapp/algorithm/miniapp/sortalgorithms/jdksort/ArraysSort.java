package algorithm.miniapp.sortalgorithms.jdksort;

import java.util.Arrays;

import algorithm.miniapp.Enum.LineColorEnum;
import algorithm.miniapp.abstraction.SortMethod;

/**
 * @author Tao
 */
public class ArraysSort implements SortMethod {

    @Override
    public String getCnName() {
        return "JDK Arrays Sort";
    }

    @Override
    public int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    @Override
    public LineColorEnum lineColor() {
        return LineColorEnum.BlueGrey;
    }

    @Override
    public String methodName() {
        return "ArraysSort";
    }

    @Override
    public void destory() {
    }
}
