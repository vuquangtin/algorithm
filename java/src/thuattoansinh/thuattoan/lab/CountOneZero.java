package thuattoan.lab;

import java.util.Arrays;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CountOneZero {
    public static void main(String[] args) {
        int[] a = new int[] {0, 0, 0, 0, 1};
        System.out.println(Arrays.toString(countOneZero(a)));
    }

    static int[] countOneZero(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int zeroPoint = 0;
        while (left < right) {
            int middle = (left + right)/2;
            if(a[middle] == 0 && a[middle + 1] == 1) {
                zeroPoint = middle;
            }

            if(a[middle] == 1) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return new int[] {zeroPoint + 1, a.length - (zeroPoint + 1)};
    }
}