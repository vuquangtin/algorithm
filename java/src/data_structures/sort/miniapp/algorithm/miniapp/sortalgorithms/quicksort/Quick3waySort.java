package algorithm.miniapp.sortalgorithms.quicksort;

import java.util.Arrays;

import algorithm.miniapp.Enum.LineColorEnum;

/**
 * @author Tao
 */
public class Quick3waySort extends QuickSort {
    @Override
    public String methodName() {
        return "Quick3waySort";
    }

    /**
     * 三向切分快速排序
     *
     * @param arr
     * @param l
     * @param r
     */
    @Override
    protected void quickSort(int[] arr, int l, int r) {
        if (r <= l) return;
        int i = l,j = l + 1,k = r,v = arr[l];
        /**
         * / 荷兰国旗问题
         *  保证i左边都小于v i和k之间都相等于v k右边都大于v
         */
        while (j <= k){
            if (arr[j] < v) swap(arr,i++,j++);
            else if (arr[j] > v) swap(arr,j,k--);
            else j++;
        }
        // 现在arr[l...i-1] < v == arr[i...j] < arr[k+1,r]成立
        quickSort(arr,l,i-1);
        quickSort(arr,k+1,r);
    }

    @Override
    public void destory() {}

    @Override
    public LineColorEnum lineColor() {
        return LineColorEnum.LightGreen;
    }

    @Override
    public String getCnName() {
        return "三向切分快速排序";
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,2,2,2,2,2,2};
        Quick3waySort quick3waySort = new Quick3waySort();
        System.out.println(Arrays.toString(quick3waySort.sort(arr)));
        long sort = quick3waySort.testSort(10000000);
        System.out.println("quick3waySort 花费时间"+sort+"ms");
    }
}
