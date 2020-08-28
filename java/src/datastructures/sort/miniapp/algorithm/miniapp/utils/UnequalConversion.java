package algorithm.miniapp.utils;

import java.text.DecimalFormat;

/**
 * 不等距坐标转换方法
 */
public class UnequalConversion {

    /**
     * 转换为等距坐标
     *  0 0.001 0.002 0.004 0.008
     *  0   1     2     3
     * @param y
     * @return
     */
    public static double conversionLoad(double y){
        DecimalFormat format = new DecimalFormat("0.00");
        double re = log(y+1,2);
        return Double.valueOf(format.format(re));
    }

    /**
     * 转换为不等距坐标
     *  0   1     2     3
     *  0   1     3     7    15
     * @param y
     * @return
     */
    public static String conversionTo(double y){
        DecimalFormat format = new DecimalFormat("0");
        double re = Math.pow(2.00,y) - 1;
        String res = format.format(re);
        return res.length() > 6 ? format.format(re / 1000000) + " ks" :
                    (res.length() > 3) ? format.format(re / 1000) + " s" : format.format(re) + " ms";
    }

    /**
     * 求对数方法
     * @param value
     * @param base
     * @return
     */
    public static double log(double value, double base){
        return Math.log(value) / Math.log(base);
    }

    /**
     * 获取边界数
     * @param length
     * @param multiplicity
     * @return
     */
    public static int getBounds(int length,double multiplicity){
        if (multiplicity == 1.0) return 1;
        if (multiplicity == 0.0) return Integer.MAX_VALUE;
        double bounds = (length + 0.00) * Math.pow((1 - multiplicity),5);
        if (bounds < 1 && length > 0) return 1;
        return (int)bounds;
    }


    public static void main(String[] args) {
        double v = conversionLoad(35271.0);
        System.out.println(v);

        String ss = conversionTo(35271.0);
        System.out.println(ss);
    }
}
