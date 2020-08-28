package algorithm.miniapp.sortalgorithms.countingsort;

import algorithm.miniapp.Enum.LineColorEnum;
import algorithm.miniapp.abstraction.SortMethod;

/**
 * @author Tao
 */
public class CountingSort implements SortMethod {

    @Override
    public String methodName() {
        return "CountingSort";
    }

    @Override
    public String getCnName() {
        return "计数排序";
    }

    /**
     * 计数排序
     *  计数排序扩展于桶排序 计算每一个桶出现的次数，每个桶再将前面的桶的依次次数叠加
     *      这样就可以得到每个桶中的值该在源数组出现的位置
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        if (arr.length <= 1) return arr;
        int max = arr[0],index = 0;
        // 寻找出最大的值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        // 最大值加一
        max++;
        // 创建一个临时数组 用于存储每个元素出现的个数
        int[] a = new int[max];
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]]++;
        }
        // 累加前面的值
        for (int i = 1; i < max; i++) {
            a[i] = a[i-1] + a[i];
        }
        // 创建目标数组 保存临时数据
        int[] desc = new int[arr.length];
        for (int i = desc.length - 1; i >= 0; i--) {
            index = a[arr[i]] - 1;
            desc[index] = arr[i];
            a[arr[i]]--;
        }
        // 拷贝临时数据到目标数组
        for (int i = 0; i < desc.length; i++) {
            arr[i] = desc[i];
        }
        return arr;
    }
    @Override
    public void destory() {}

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        long sort = countingSort.testSort(10000000);
        System.out.println("花费时间"+sort+"ms");
    }

    @Override
    public LineColorEnum lineColor() {
        return LineColorEnum.Purple;
    }

}
