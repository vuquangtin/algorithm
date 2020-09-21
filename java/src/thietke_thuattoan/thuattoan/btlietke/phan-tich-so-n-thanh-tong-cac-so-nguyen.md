# Phân tích số N thành tổng các số nguyên (thuật toán quay lui)
@see [https://www.rebvn.com/2018/04/phan-tich-so-n-thanh-tong-cac-so-nguyen.html](https://www.rebvn.com/2018/04/phan-tich-so-n-thanh-tong-cac-so-nguyen.html)

Nối tiếp loại bài về thuật toán Quay lui, bài toán tiếp theo mà chúng ta sẽ giải quyết đó là phân tích số nguyên N thành tổng các số nguyên dương khác. Và tất nhiên, chúng ta sẽ dùng thuật toán Quay lui để giải quyết bài toán này.

Nối tiếp loại bài về thuật toán Quay lui, bài toán tiếp theo mà chúng ta sẽ giải quyết đó là phân tích số nguyên N thành tổng các số nguyên dương khác. Và tất nhiên, chúng ta sẽ dùng thuật toán Quay lui để giải quyết bài toán này.

Nếu mới bắt đầu với thuật toán quay lui, các bạn nên đọc bài này để có thể hiểu quay lui là gì, và một chương trình quay lui đơn giản sẽ chạy như thế nào : Liệt kê quay lui dãy nhị phân độ dài n. Đọc bài này sẽ giúp các bạn hiểu bài toán hiện tại dễ dàng hơn.

### Đề bài :
Nhập vào số nguyên dương N bất kì. Hãy in ra tất cả các cách phân tích số N thành tổng của các số nguyên dương khác.

### Input : 
yêu cầu người dùng nhập vào N.

### Output : 
In ra tất cả các cách phân tích số N thành tổng các số nguyên.

### Ví dụ :

Input : N = 6

### Output :

```
6 = 1 + 1 + 1 + 1 + 1 + 1
6 = 1 + 1 + 1 + 1 + 2
6 = 1 + 1 + 1 + 3
6 = 1 + 1 + 2 + 2
6 = 1 + 1 + 4
6 = 1 + 2 + 3
6 = 1 + 5
6 = 2 + 2 + 2
6 = 2 + 4
6 = 3 + 3
6 = 6
```
### Ý tưởng : 
Chúng ta sẽ lưu nghiệm vào một mảng. ta đặt tên mảng này là X.

Ví dụ : với N = 6 thì 6 = 1 + 2 + 3 là một nghiệm, và ta sẽ lưu các giá trị 1, 2, 3 vào mảng X. lúc này mảng X sẽ có 3 phần tử là 1, 2, 3

Từ đó dễ thấy, X phải chứa được N phần tử. vì nghiệm dài nhất là : `N = 1 + 1 + 1 + ... + 1` (có N số 1)

Tiếp theo, các bạn hãy nhìn vào ví dụ khi N = 6, để liệt kê các bộ nghiệm mà không lo bị trùng, hay lặp (do việc đảo thứ tự : `6 = 1 + 5` với `6 = 5 + 1` chỉ coi là một kết quả.) thì chúng ta sẽ cần điều kiện :

>Mọi phần tử trong mảng nghiệm phải lớn hơn hoặc bằng phần tử trước nó.

Gọi `X[i]` là một phần tử trong mảng nghiệm, thì :  `X[i]  ≥  X[i - 1]`  (với mọi 0  ≤  i  ≤  N - 1)

Vậy một phần tử `X[i]` bất kì có cận dưới là `X[i - 1]`. Thế còn cận trên thì sao ?

Giả sử, mảng nghiệm hiện tại đang là : 
`N = X[0] + X[1] + X[2] + ..... + X[i-1] + X[i] + ....`

Suy ra : 
`X[0] + X[1] + X[2] + ..... + X[i-1] + X[i]   ≤   N.
          ⇒ X[i]   ≤   N - X[0] - X[1] - X[2] - ..... - X[i-1]`

Dấu bằng xảy ra khi : `X[i] = N - X[0] - X[1] - X[2] - ..... - X[i-1]`. Hay nói cách khác `X[i]` là phần tử cuối cùng của mảng nghiệm. Trường hợp không xảy ra dấu bằng nghĩa là sau `X[i]` vẫn còn phần tử khác.

Ví dụ : `10 = 1 + 1 + 2 + a + ..... ` (a là một số nguyên). thì tất nhiên`a  ≤  10 - 1 - 1 - 2` hay `a  ≤  6`. Nếu a = 6 thì a là phần tử cuối của mảng nghiệm (1, 1, 2 , 6) còn `a < 6` thì sau a vẫn phải còn phần tử khác. Khi `a < 6` thì a phải thoải mãn điều kiện `a  ≥ 2`. (phần tử sau lớn hơn bằng phần tử trước.)

Vì vậy cận trên của một phần tử `X[i]` sẽ là :

`X[i]  ≤  N trừ đi (tổng của các phần tử X[0] đến X[i - 1])`.

Để tiện cho việc tìm cận trên, ta sẽ tạo một mảng T. với `T[i]` sẽ là tổng của các phần tử `X[0]` đến `X[i]`.

Hay :

```
T[i]        	= X[0] + X[1] + X[2] + .... + X[i]
T[i + 1]  	= X[0] + X[1] + X[2] + .... + X[i] + X[i + 1] = T[i] + X[i + 1]
T[i  - 1]  	= X[0] + X[1] + X[2] + .... + X[i] + X[i - 1]
```

Khi đó,  cận trên của X[i] sẽ là : `X[i]  ≤  N - T[i - 1]`.

Vậy, khoảng chạy của một phần tử X[i] trong vòng quay lui là :

`X[i - 1]  ≤  X[i]  ≤  N - T[i - 1]`.

### Lưu ý khi viết code :
với điều kiện : `X[i]   ≥  X[i - 1]` thì phần tử đầu tiên của mảng nghiệm : `X[0]` sẽ không có phần tử nào trước nó để chúng ta xét : `X[0]  ≥  X[0 - 1]` (Vì nó là phần tử đầu nên tất nhiên sẽ không có phần tử nào trước nó nữa.).

Vì vậy, khi khai báo mảng nghiệm X, ta cần khai báo X có N + 1 phần tử (0 ≤  i ≤  N). và mảng nghiệm chỉ tính từ phần tử X[1] tới phần tử X[N]. Để phần tử đầu mảng nghiệm là X[1] có thể xét cận dưới như các phần tử khác của mảng : `X[1]  ≥  X[0]` (ta sẽ cho mặc định `X[0] = 1`. và X[0] là khôngđược coi như một phần tử của mảng nghiệm, nó chỉ được tạo ra để gán giá trị cho X[1])

Ta có : `T[0] = 0`.

Có thể các bạn sẽ không hiểu đoạn trên, các bạn hãy đọc phần bên dưới và xem Code tham khảo sẽ thấy dễ hiểu hơn tại sao cần tạo X có N + 1 phần tử.

Hiện tại các bạn cứ hiểu là : mảng X sẽ có N + 1 phần tử và X[0] = 1, T[0] = 0.

### Vòng quay lui sẽ chạy như sau :

- Gán các có thể nhận được cho phần tử X[1] :  `X[0] = 1  ≤  X[1]  ≤  N - T[0] = N` (Vì T[0] = 0)
- Tại mỗi lần gán giá trị cho `X[1]`, ta sẽ gán các giá trị có thể nhận được cho `X[2]` : `X[1]  ≤  X[2]  ≤  N - T[1]`
- Tiếp đó, trong mỗi lần gán giá trị cho `X[2]`, ta sẽ gán các giá trị có thể nhận được cho `X[3]` : `X[2]  ≤  X[3]  ≤  N - T[2]`
....
- cứ thế, khi nào `T[i] = X[1] + [2] + ... X[i] = N` thì có nghĩa là ta đã tìm được một nghiệm, lúc này ta sẽ in ra nghiệm mới tìm được từ X[1] đến X[i]. Và quay lui lại tìm tiếp.

Các bạn có thể đọc bài này để hiểu quá trình quay lui lại tìm tiếp sẽ diễn ra như thế nào : Liệt kê quay lui dãy nhị phân độ dài n.

### C Code tham khảo :

```C++
#include<stdio.h>
#include<conio.h>
 
void xuLy(int n, int X[], int T[], int i)
{
    int j;
    for(j = X[i - 1]; j <= (n - T[i - 1]); j++)  // X[i-1] <= X[i] <= n - T[i-1]
    {
        X[i] = j;
        T[i] = T[i - 1] + j;
 
        if(T[i] == n)   // nếu T[i] = n
        {
            int temp;
            for(temp = 1;  temp <= i; temp++)   // in ra từ X[1] tới X[i]
            {
                printf("%d  ", X[temp]);
            }
            printf("\n");
        }
 
        else
        {
            xuLy(n, X, T, i + 1);
        }
    }
}
 
int main()
{
    int n;
    printf("Nhap vao n : ");
    scanf("%d", &n);
 
    int X[n + 1];  // mảng X có N + 1 phần tử
    int T[n + 1];
 
    X[0] = 1;
    T[0] = 0;
 
    xuLy(n, X, T, 1);  // mảng nghiệm tính từ i = 1
 
    getch();
    return 0;
}
```