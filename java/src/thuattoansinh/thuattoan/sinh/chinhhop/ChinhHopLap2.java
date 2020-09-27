package thuattoan.sinh.chinhhop;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ChinhHopLap2 {
    
    public static void main(String[] args){
        
        // n & k
        int n = 6, k = 4;

        inChinhHop(6,4);
    }

    public static void inChinhHop(int n, int k){
        // tao ra mang
        int[] chinhHop = new int[k];
        khoiTao(chinhHop);

        // bien kiem tra  
        int i = k-1;

        while(i >= 0) {
            i=k-1;
            inRa(chinhHop);
            // tai tao cau hinh chinh hop

            while(i >= 0 && chinhHop[i] == n){
                i--; // xem xet so phia truoc
            }
            if (i >= 0 && chinhHop[i] < n){
                chinhHop[i]++;

                for(int j=i+1;j<k;j++){
                    chinhHop[j]=1;
                }
            }
        }

        // inRa(chinhHop);
    }

    public static void khoiTao(int[] mang){
        for(int i=0; i< mang.length ; i++){
            mang[i] = 1;
        }
    }

    public static void inRa(int[] mang){
        for(int i=0; i< mang.length ; i++) {
            System.out.print(mang[i] + " ");
        }
        System.out.println();
    }
}