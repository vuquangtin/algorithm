package thuattoan.sinh.xaunhiphan;

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
public class BinaryStringEnumeration {
    public static void main(String[] args) {
        int[] x = new int[3];
        back(x, 0);
    }

    static void back(int[] x, int i) {
        for(int j = 0; j <= 1; j++) {
            x[i] = j;
            if(i == x.length - 1) {
                System.out.println(Arrays.toString(x));
            } else {
                back(x, i + 1);
            }
        }
    }
}