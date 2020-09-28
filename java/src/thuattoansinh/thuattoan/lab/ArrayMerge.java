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
public class ArrayMerge {
    public static void main(String[] args) {
        int[] a = new int[] {1, 4, 5, 8, 17};
        int[] b = new int[] {2, 4, 8, 11, 13, 21, 23, 25};
        System.out.println(Arrays.toString(merge(a, b)));
    }

    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while(i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }
        while(j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }
}
