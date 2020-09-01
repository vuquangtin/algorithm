package algorithm.miniapp.sortalgorithms.quicksort;

import algorithm.miniapp.view.manoeuvre.AlgoFrame;

public class Quick1ScanFrame extends QuickFrame {

    @Override
    protected int partition(AlgoFrame frame, int l, int r) {
        int i = l;
        for (int j = l; frame.compareLessOrEqual(j, r - 1); j++) {
            if (frame.less(j,r)){
                frame.swap(i++,j);
            }
        }
        frame.swap(i,r);
        return i;
    }

    @Override
    public String getCnName() {
        return "单向扫描快速排序";
    }
}
