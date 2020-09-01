package algorithm.miniapp.sortalgorithms.bucketsort;

import algorithm.miniapp.abstraction.SortVisual;
import algorithm.miniapp.view.manoeuvre.AlgoFrame;

/**
 * @author Tao
 */
public class BucketFrame implements SortVisual {


    @Override
    public String getCnName() {
        return "桶排序";
    }

    /**
     * 桶排序图形化
     * @param frame
     */
    @Override
    public void sort(AlgoFrame frame) {

    }

    @Override
    public String methodName() {
        return "Bucket Sort";
    }
}
