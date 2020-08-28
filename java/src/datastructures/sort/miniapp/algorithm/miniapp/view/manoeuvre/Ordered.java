package algorithm.miniapp.view.manoeuvre;

public class Ordered {

    private int orderedstart = -1;
    /**
     * [orderedstart...orderedIndex) 是有序的
     */
    private int orderedIndex = -1;

    public int getOrderedstart() {
        return orderedstart;
    }

    public void setOrderedstart(int orderedstart) {
        this.orderedstart = orderedstart;
    }

    public int getOrderedIndex() {
        return orderedIndex;
    }

    public void setOrderedIndex(int orderedIndex) {
        this.orderedIndex = orderedIndex;
    }

    public Ordered(){}

    public Ordered(int orderedIndex) {
        this(-1,orderedIndex);
    }

    public Ordered(int orderedstart, int orderedIndex) {
        this.orderedstart = orderedstart;
        this.orderedIndex = orderedIndex;
    }

    /**
     * 是否在当前区间
     * @param index
     * @return
     */
    public boolean isBetween(int index){
        return this.isBetween(this.orderedstart,this.orderedIndex,index);
    }

    /**
     * 是否在当前区间
     * @param index
     * @return
     */
    public boolean isBetween(int start,int end,int index){
        if(index >= start && index < end){
            return true;
        }
        return false;
    }

    /**
     * 判断区间和当前区间是否相交
     * @param orderedstart
     * @param orderedIndex
     * @return
     */
    public boolean isIntersect(int orderedstart,int orderedIndex){
        // 初始化相交
        if (orderedIndex <= 0 || orderedstart < 0) return true;
        // 如果负区间 则合并
        if (orderedIndex < orderedstart) return true;
        // 如果重合 相交
        if (orderedIndex == orderedstart) return true;
        // 如果当前区间等于传入区间接尾 相交
        if (this.orderedIndex == orderedstart || this.orderedstart == orderedIndex) return true;
        // 如果当前区间包含传入区间(相互包含) 相交
        if (this.isBetween(orderedIndex) || this.isBetween(orderedstart)) return true;
        if (this.isBetween(orderedstart,orderedIndex,this.orderedstart) ||
                this.isBetween(orderedstart,orderedIndex,this.orderedIndex)) return true;
        // 如果当前区间小于或大于传入区间 不相交
        return false;
    }

    @Override
    public String toString() {
        return "Ordered{" +
                "orderedstart=" + orderedstart +
                ", orderedIndex=" + orderedIndex +
                '}';
    }
}
