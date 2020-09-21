# Thuật toán sinh các dãy nhị phân có độ dài n

>Bài toán liệt kê các dãy nhị phân độ dài n là bài toán cổ điển dùng để minh họa cho phương pháp sinh và thuật toán quay lui. Trong bài này, mình sẽ viết về thuật toán sinh các dãy nhị phân độ dài n hay nói cách khác là liệt kê các dãy nhị phân có độ dài n bằng phương pháp sinh.

Bài toán liệt kê các dãy nhị phân độ dài n là bài toán cổ điển dùng để minh họa cho phương pháp sinh và thuật toán quay lui. Trong bài này, mình sẽ viết về thuật toán sinh các dãy nhị phân độ dài n hay nói cách khác là liệt kê các dãy nhị phân có độ dài n bằng phương pháp sinh.

Nếu các bạn muốn tham khảo cách giải bài toán này bằng thuật toán quay lui thì có thể đọc bài này : Liệt kê quay lui dãy nhị phân độ dài n.

###Yêu cầu 

Viết chương trình in ra các chuỗi nhị phân có độ dài n. (chuỗi nhị phân có độ dài n là chuỗi số có số chữ số bằng n và các chữ số trong chuỗi chỉ gồm 0 và 1.)

### Input 
Độ dài của chuỗi nhị phân cần in ra

### Output 
In ra tất cả chuỗi nhị phân có độ dài ở đầu vào.

### Ví dụ :

Input : 3

Out put : 000   001   010   011   100   101   110   111

>Nhận xét : Chuỗi nhị phân có độ dài là n. Mỗi vị trí trong dãy sẽ có thể chọn 1 trong 2 số : 0 hoặc 1. Hay mỗi vị trí trong dãy đều có 2 cách chọn. Và vì dãy có n vị trí, nên sẽ có tất cả 2^n (2 mũ n) khả năng xảy ra. Nói cách khác, sẽ có 2^n dãy nhị phân độ dài n.

Như ví dụ mình đưa bên trên với đầu vào là 3 thì đầu ra sẽ là 2^3 = 8 dãy nhị phân.

### Trước khi đọc ý tưởng : 
các bạn hãy thử nhìn vào Output ở ví dụ bên trên coi như là 1 gợi ý để nghĩ ra cách giải quyết bài toán này. Vì thứ tự của các chuỗi trong ví dụ trên cũng chính là thứ tự của các dãy nhị phân được in ra khi chạy chương trình.

Nếu đã nghĩ ra thì bạn hãy thực hiện xem hoặc thử kéo xuống để xem có trùng với lời giải hay không nhé.

Nếu không nghĩ ra cũng không sao cả, vì mình cũng không nghĩ ra giống bạn. =)).

### Bổ trợ : 
Ta sử dụng phương pháp sinh để giải một bài toán khi :

- chúng ta biết được quy luật của bài toán liệt kê, từ đó biết được cấu hình đầu và cấu hình cuối trong bài toán. (các bạn có thể hiểu đơn giản một cấu hình là một số cần liệt kê.)

-  có thể xây được được thuật toán để từ một cấu hình bất kì trong bài toán có thể suy ra được các cấu hình cần liệt kê tiếp sau nó.

### Ý tưởng : 
Chúng ta sẽ dùng phương pháp sinh để giải bài toán này vì thế chúng ta cần biết cấu hình đầu (chuỗi nhị phân đầu được in ra) và cấu hình cuối (chuỗi nhị phân cuối được in ra).

Nhìn vào ví dụ, các bạn sẽ thấy cầu hình đầu là 0000....00 và cấu hình cuối sẽ là 1111...11

Từ chuỗi đầu tiên là 0000...00, chúng ta sẽ duyệt từ cuối chuỗi về đầu chuỗi (từ vị trí thứ n của chuỗi đi dần lên). Khi đang đi lên : nếu gặp số 0 đầu tiên, chúng ta sẽ đổi nó thành số 1 và toàn bộ các phần tử phía sau nó thành số 0. Sau đó, lại quay về vị trí cuối dãy duyệt lên. Cứ thế cho đến khi không thấy số 0 nào nữa nghĩa là đã được cấu hình cuối 1111..11

Các bạn hãy nhìn vào ví dụ dưới rồi đọc lại dòng trên để dễ hiểu hơn.

ví dụ :  
0-0-0   
0-0-1   
0-1-0   
0-1-1   
1-0-0   
1-0-1   
1-1-0   
1-1-1

### Các bước viết chương trình :
 - yêu cầu người dùng nhập vào độ dài chuỗi n.
 - khai báo mảng số nguyên có độ dài n.
 - khởi tao tất cả các phần tử của mảng bằng 0. (cấu hình đầu) và in ra.
 - dùng vòng lặp duyệt từ cuối mảng (vị trí n - 1) đi lên gặp phần tử mảng có giá trị bằng 0 đầu tiên thì gán lại giá trị của phần tử này thành 1. tiếp đó dùng 1 vòng lặp khác (vòng lặp con bên trong vòng lặp hiện tại) để gán toàn bộ giá trị của các phần tử phía sau nó thành 0. sau đó in ra mảng hiện tại.
 - thay vì để vị trí -- (giảm tiếp) ta sẽ gán lại giá trị của vị trị thành n để chạy lại từ cuối mảng.
 - Chương trình sẽ tự dừng khi là cấu hình cuối 1111...11 vì lúc này sẽ không còn số 0 nào cả.
 
###  C Code Sinh dãy nhị phân độ dài n :

```C++
#include<stdio.h>
#include<conio.h>
 
int main()
{
    int n;
 
    // yeu cau nguoi dung nhap vao do dai chuoi n
    printf("Nhap vao do dai day nhi phan : ");
    scanf("%d", &n);
 
 
    // khoi tao mang n phan tu va gan cac phan tu cua mang bang 0
    int mang[n];
 
    int i;
    for(i = 0; i < n; i++)
    {
        mang[i] = 0;
    }
 
 
    // in ra cau hinh dau
    for(i = 0; i < n; i++)
    {
        printf("%d", mang[i]);
    }
    printf("\n");
 
 
    //xu ly
    for(i = n - 1; i >= 0; i--)
    {
        if(mang[i] == 0)  // neu gap phan tu 0 dau tien
        {
            mang[i] = 1;  // gan no lai thanh 1
 
            int j;
            for(j = i + 1; j < n; j++)  // gan toan bo phan tu phia sau no thanh 0
            {
                mang[j] = 0;
            }
 
            // in ra day so moi
            for(j = 0; j < n; j++)
            {
                printf("%d", mang[j]);
            }
            printf("\n");
 
            i = n;  // gan i = n de khi het vong lap i-- nen i se = n - 1, tu do chay lai tu vi tri cuoi.
                    // gan i = n - 1 la sai vi khi het vong lap hien tai i-- se thanh n - 2.
        }
    }
 
    getch();
    return 0;
}

```