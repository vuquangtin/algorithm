package thuattoan.sinh.tohop;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SinhChuoi {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        sinhChuoi(chars, 3);
    }

    static void sinhChuoi(char[] chars, int k) {
        boolean check = false;
        char[] x = new char[k];
        //use a position array to store index of a character.
        int[] position = new int[k];

        for(int i = 0; i < k; i++) {
            x[i] = chars[i];
            position[i] = i;
        }

        while (!check) {
            for (char c: x) {
                System.out.print(c);
            }
            System.out.println();
            int i = k - 1;
            while(i >=0 && (x[i] == chars[chars.length - k + i])) {
                i--;
            }

            if(i >= 0) {
                x[i] = chars[++position[i]];
                for(int j = i + 1; j < k; j++) {
                    x[j] = chars[position[j - 1] + 1];
                    //update index for the characters after character i/th.
                    position[j] = position[j - 1] + 1;
                }
            } else {
                check = true;
            }
        }
    }
}