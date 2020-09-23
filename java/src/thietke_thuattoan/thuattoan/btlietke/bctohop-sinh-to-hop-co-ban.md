# BCTOHOP - Sinh tổ hợp (Cơ bản) 

Link Sub: http://www.spoj.com/PTIT/problems/BCTOHOP/



## Problem:

Một tổ hợp chập k của n là một tập con k phần tử của tập n phần tử.
Chẳng hạn tập {1, 2, 3, 4} có các tổ hợp chập 2 là:

```
{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}
```
Vì trong tập hợp các phần thử không phân biệt thứ tự nên tập `{1, 2}` cũng là tập `{2, 1}`, do đó ta coi chúng chỉ là một tổ hợp.

Bạn hãy sinh hết tổ hợp chập của n phần tử, n phần tử gồm các số nguyên từ 1 đến n.
Các tập con in ra theo thứ tự từ điển. Ví dụ: `{1, 2, 3, 4} < {1, 3, 2 4}`.

## Input
Một dòng duy nhất gồm 2 số nguyên n, k (1 <= k <= n <= 10)
## Output
Mỗi một tổ hợp chập k in ra trên một dòng.
## Example: 

```
Input

4 2

Output:

1 2
1 3
1 4
2 3
2 4
3 4

```


## Solution:

Code C:

Sinh hoán vị thông thường:
 
- Khởi tạo cấu hình ban đầu: `1 2 3 ... k`; 
- Tìm vị trí mà tại đó phần tử [i] chưa đạt cấu hình cuối (!=n-k+i). Nếu không tìm thấy thì đã đạt cấu hình cuối (stop). 
- Tăng [i]++; và các phần tử sau nó [i+1]= [i]+1, [i+2]=[i]+2, ...

## Code:

```C
#include <stdio.h>
 
int n, k;
int th[11];
 
void khoitao () {
    for (int i=1; i<=k; i++){
        th[i]=i;
    }
}
 
void in () {
    for (int i=1; i<=k; i++) {
        printf ("%d ", th[i]);
    }
}
 
int dung=0;
void sinhth () {
    int i=k;
    while (i>0 && th[i]==n-k+i) i--;
    if (i>0) {
        th[i]++;
        for (int j=i+1; j<=k; j++) {
            th[j]=th[i]+j-i;
        }
    } else dung=1;
}
 
int main () {
    scanf ("%d%d", &n, &k);
   
    khoitao ();
    do {
        in ();
        printf ("\n");
        sinhth ();
    } while (dung!=1);
   
    return 0;
}
```