package thuattoan.btlietke.phuongphapsinh;

import java.util.Scanner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class PhanTichTong {
    private int t[], x[], n;
    
    public PhanTichTong() {
        Init();  
    }
    
    public void Init() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào n:");
        n = input.nextInt();
        t = new int[n+1];
        t[0] = 0;
        x = new int[n+1];
        x[0] = 1;
        
    }
    
    public int getValue() {
        return n;
    }
    
    public void printResult(int k) {
        for (int j = 1; j < k; j++) {
            System.out.print(x[j] + " + ");
        }
        System.out.println(x[k]);
    }
    
    public void Attemp(int i) {
        for (int j = x[i - 1]; j <= (n - t[i - 1])/2; j++) { //Các giá trị x[i] có thể chọn
            x[i] = j;//Mảng chứa các giá trị tổng
            t[i] = t[i-1] + j; //Mảng lưu trữ tổng
            Attemp(i + 1);
        }
        //System.out.println("Giá trị của i là: " + i);
        x[i] = n - t[i-1];//Nếu x[i] là phần tử cuối thì buộc nó phải có giá trị
            printResult(i);
    }
    public static void main(String[] args) {
        PhanTichTong pt = new PhanTichTong();
        System.out.println("Số cách phân tích " + pt.getValue() + " thành tổng là:");
        pt.Attemp(1);
    }
    
}