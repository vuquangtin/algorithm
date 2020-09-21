# Liệt kê Quay lui chỉnh hợp không lặp chập k của n phần tử

Ở bài trước, mình đã viết về cách sử dụng thuật toán Quay lui để giải quyết bài toán liệt tập con k phần tử. Ở bài này, mình sẽ nói về cách sử dụng Quay lui để giải quyết một bài toán nâng cao hơn một chút : Liệt kê chỉnh hợp không lặp chập k của n phần tử.

### Yêu cầu : 
Cho tập n phần tử là các số tự nhiên từ 1 đến n. Hãy viết chương trình liệt kê ra tất cả các chỉnh hợp không lặp chập k tập này.

### Input : 
Yêu cầu người dùng nhập vào hai số n và k.

### Output : 
In ra màn hình tất cả các chỉnh hợp không lặp chập k của tập n phần tử.

### Ví dụ : 

Input : n = 3, k = 2

Output : 12   13   21   23   31   32


### Nhận xét :  
Một chỉnh hợp chập k của tập n phần tử sẽ thỏa mãn các tính chất sau (nếu thấy đoạn dưới hơi khó hiểu các bạn hãy xem ví dụ tiếp dưới nó sẽ dể hiểu hơn.) :

1.  Một chỉnh hợp chập k sẽ có k vị trí. (Hay nói cách khác là sẽ có k phần tử lấy từ tập n phần tử : từ 1 đến n)

2.  Vì đây là một chỉnh hợp (có xét tính đến thứ tự), nên một vị trí bất kì trong chỉnh hợp có thể nhận mọi giá trị từ 1 đến n.

3.  Vì đây là chỉnh hợp không lặp nên trong chỉnh hợp, giá trị của một vị trí không được trùng với các giá trị của vị trí. (các vị trí khác nhau thì có giá trị khác nhau.)

Ví dụ :

Input : n = 3, k = 2

Output : 12   13   21   23   31   32

1.  Như 13 là một phần tử thỏa mãn : ta thấy 13 có 2 vị trí. vị trí thứ nhất có giá trị là 1, vị trí thứ hai có giá trị là 3.

2.  Hãy nhìn vào các phần tử thoả mãn còn lại, các bạn sẽ thấy các vị trí trong các phần tử có thể nhận mọi giá trị trong 1 đến n.

3. Hãy nhìn vào một phần tử bất kì ở Ouput, các vị trí khác nhau trong phần tử này đều phải nhận hai giá trị khác nhau. (Ví dụ : 22 hay 11 hay 33 thì sẽ không thỏa mãn yêu cầu không lặp của bài toán.)

Từ 3 nhận xét trên, ta sẽ có được ý tưởng giải quyết bài toán.

### Ý tưởng :  

Vì mỗi vị trí có thể nhận mọi giá trị từ 1 đến n nhưng vì các vị trí khác nhau phải có các giá trị khác nhau. Nên khi gán giá trị cho một vị trí, ta cần xét xem giá trị chuẩn bị gán cho vị trí này đã được gán cho vị trí nào trước đó chưa. (để tránh các tình huống không thỏa mãn bài toán như : 11 hay 22 hay 33 xảy ra).

### Các bước làm sẽ như sau :

-  Gán các giá trị có thể nhận được cho vị trí thứ 1. (Các giá trị nhận được của vị trí thứ 1 là từ 1 đến n)
-  Tại mỗi lần gán giá trị cho vị trí thứ 1, ta sẽ gán giá trị các giá trị có thể cho vị trí thứ 2 bằng cách gọi thủ tục đệ qui `Try(i + 1)`  (Các giá trị có thể nhận được của vị trí thứ 2 là từ 1 đến n, nhưng chỉ được lấy giá trị chưa được gán cho vị trí thứ 1.)
-  Tại mỗi lần gán giá trị cho vị trí thứ 2, ta sẽ gán giá trị các giá trị có thể cho vị trí thứ 3 bằng cách gọi thủ tục đệ qui `Try(i + 2)`. (Các giá trị có thể nhận được của vị trí thứ 3 là từ 1 đến n, nhưng chỉ được lấy giá trị chưa được gán cho vị trí thứ 1 và thứ 2.)
......
-  Cứ như thế sau khi gán xong giá trị cho vị trí thứ k thì ta sẽ in ra chỉnh hợp vừa tìm được. Sau đó quay lui lại để tìm tiếp.

>Để xét xem 1 giá trị đã được gán cho một vị trí nào ở trước vị trí hiện tại chưa ta sẽ tạo một mảng kiểu luận lý Bool gồm n phần tử, và gán giá trị mặc định cho các phần tử trong mảng này là true. Giá trị nào đã được gán rồi thì đặt lại Bool của nó bằng false (Không được gán cho vị trí khác nữa).

Khi gán giá trị cho một vị trí, ta sẽ kiểm tra xem Bool của giá trị đang gán là true hay false. Nếu là true thì sẽ cho phép gán, sau khi gán xong thì đổi thành false để các vị trí sau không được lấy dùng giá trị này nữa.

Nếu vị trí này là vị trí k thì tiến hành in ra bộ số mới tìm được, nếu chưa phải k thì gọi đệ qui `Try(i + 1)`. Sau khi gọi để quị `Try(i + 1)` có nghĩa là sắp tới ta sẽ thử một giá trị khác cho vị trí i vì thế sau khi gọi `Try(i + 1)` ta cần gán lại bool của giá trị mới gán cho vị trí i khi chưa gọi `Try(i + 1)` thành true - nghĩa là chưa được sử dụng. Vì lúc này các vị trí i + 1, i + 2 đã có thể sử dụng nó.

### Một ví dụ cho dễ hiểu nào :

-  ta đang gán cho vị trí i giá trị a nào đó (giả sử bool của a đang là true nên gán được)
-  gán lại cho bool của a thành false để các vị trí i + 1, i + 2, .... không được dùng giá trị a nữa.
-  gọi `Try(i + 1)` để tiến hành gán giá trị cho i + 1.
-  khi kết thúc đệ qui `Try(i + 1)` thì sẽ quay lui lại gán giá trị khác cho vị trí i. Vì vị trí i đã được gán giá trị mới, không còn sử dụng giá trị a nữa. nên lúc này giá trị a là tự do, và có thể dùng để gán cho các vị trí i + 1, i + 2, ... Vì thế ta sẽ gán lại bool của a thành true.

Code C Liệt kê Quay lui chỉnh hợp không lặp chập k của n phần tử :

```C++
#include<stdio.h>
#include<conio.h>
 
int Try(int n, int k, int mang[], int i, bool check[])
{
    int j;
    for(j = 0; j < n; j++)
    {
        if(check[j] == true)  // nếu chưa được gán cho các vị trí phía trước
        {
            mang[i] = j + 1;
            check[j] = false;  // đổi lại thành false để các vị trí sau không được dùng nữa
 
            if(i == (k - 1))
            {
                int temp;
                for(temp = 0; temp < k; temp++)
                {
                    printf("%d  ", mang[temp]);
                }
                printf("\n");
            }
             
            else
            {
                Try(n, k, mang, i + 1, check);
            }
 
            check[j] = true;   // gán lại thành true để vì vị trí i hiện sắp tới không sử dụng giá trị j nữa.
        }
    }
 
}
 
int main()
{
    int n, k;
 
    printf("Nhap vao n : ");
    scanf("%d", &n);
 
    printf("Nhap vao k : ");
    scanf("%d", &k);
 
    bool check[n];  // khai báo mảng bool gồm n phần tử
 
    int i;
    for(i = 0; i < n; i++)   // khởi tạo giá trị cho mảng bool 
    {
        check[i] = true;
    }
 
    int mang[k];
 
    Try(n, k, mang, 0, check);
 
    getch();
    return 0;
}
```
