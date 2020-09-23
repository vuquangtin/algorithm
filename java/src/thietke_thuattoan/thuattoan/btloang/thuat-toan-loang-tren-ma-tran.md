# Thuật toán loang trên ma trận
>Thuật toán loang (Thuật toán vết dầu loang) là một trong những thuật toán được dùng khá nhiều trong tin học, điển hình là thuật toán loang trên ma trận này được ứng dụng để đếm số thành phần liên thông trên ma trận. Nó trong các trò chơi nổi tiếng như line 98, trò chơi dò mìn trên windows, tìm đường đi ngắn nhất trên ma trận…

## 1. Giới thiệu thuật toán vết dầu loang

Thuật toán loang có tên gọi như vậy vì nguyên lý hoạt động của nó giống vết dầu loang. Từ một vết dầu nhỏ sẽ được loang ra xung quanh. Thuật toán loang trên ma trận cũng vậy, bạn sẽ duyệt một ô trên ma trận và sau đó duyệt các điểm xung quanh nó và dần loang ra để giải quyết bài toán.

Như trong trò chơi dò mìn, để giải quyết được trò chơi, bạn phải chọn một điểm ban đầu, và xử lí các thông tin tại đó để có thể dò được các bãi mìn xung quanh, và bạn sẽ làm như vậy đến khi không còn loang được nữa.

Tư tưởng của thuật toán loang chỉ có vậy, trong bài viết này mình sẽ cố gắng giới thiệu bạn rõ hơn về việc ứng dụng nó qua một vài ví dụ.

Bài trên bạn có thể dùng thuật toán BFS hoặc DFS để loang ra từng vùng có các kí tự giống nhau. cách tổ chức code khi loang ra bạn có thể tham khảo như bài này https://kienthuc24h.com/co-ban-ung-dung-bfs-de-giai-quyet-bai-tap-duong-di-cua-quan-ma-trong-thi/ bạn sẽ khai báo như sau

```C++
int cld[8]={1,-1,0,0};
int clc[8]={0,0,1,-1};
```

Và tiến hành loang và đếm thành phần liên thông theo hướng làm như sau:

## 2. Code loang đếm thành phần liên thông c++

```c++	
res = 0;
for (int i=1; i<=r; i++)
    for (int j=1; j<=c; j++)
        if (chưa duyệt ô i,j) 
        {
            res++;
            bfs(i,j);
        }
```

## 3. Bài tập minh họa
### a. Đề bài toán thứ 2

Link đề bài http://www.spoj.com/THPTCBT/problems/MTKPMANG/

**Khôi phục mảng**

Chúng ta sẽ có một ma trận gồm các số `0,1`. Và từ ma trận `A` chúng ta sẽ tạo được ma trận `B` với `B[i,j]` là số lượng ô có giá trị bằng 1 kề cạnh với` A[i,j]`

Cho trước mảng `B`, hãy  khôi phục mảng `A`.

Nếu không thể khôi phục thì ghi ra dòng chữ “KHONG THE”
### b. Example

Input:

```
4 4
1 2 1 1
2 2 3 1
3 2 2 2
0 3 1 1
```

Output:

```
1 0 0 1
1 1 0 1
0 1 1 0
1 0 1 0
```

Bài toán trên cũng là tư tưởng loang nhưng lúc này chúng ta không tiếp cận chúng từ 1 vị trí, mà dựa vào các đặc điểm tối thiểu của nó để kết luận kết quả bài toán.

Ví dụ trong bài toán trên, bạn có thể đi lên từ các trường hợp, số 0 ở các góc, khi đó bạn điền được 2 số 1, số 3 ở cạnh, trường hợp số 0 điền được 4 số 1,…. ý tưởng tổng quát là vậy.

### c. Code lời giải

```pascal
const   fi='';
        nmax=50;
        cld:array[1..4] of shortint=(1,-1,0,0);
        clc:array[1..4] of shortint=(0,0,1,-1);
 
type    data=longint;
var
        f:text;
        A,B:array[0..nmax+1,0..nmax+1] of data;
        n,m:data;
        kt,free:array[0..nmax+1,0..nmax+1] of boolean;
        sl:data;
 
procedure docfile;
var     i,j:data;
begin
        assign(f,fi); reset(f);
        readln(f,m,n);
        for i:=0 to m+1 do
                for j:=0 to n+1 do
                        b[i,j]:=2;
 
        for j:=0 to n+1 do
                begin
                        Free[0,j]:=true;
                        Free[m+1,j]:=true;
                        kt[0,j]:=true;
                        kt[m+1,j]:=true;
                        B[0,j]:=0;
                        B[m+1,j]:=0;
                end;
        for i:=0 to m+1 do
                begin
                        free[i,0]:=true;
                        free[i,n+1]:=true;
                        kt[i,0]:=true;
                        kt[i,n+1]:=true;
                        B[i,0]:=0;
                        B[i,n+1]:=0;
                end;
 
        for i:=1 to m do
                for j:=1 to n do
                        read(f,a[i,j]);
        close(f);
end;
 
procedure xuat;
var     i,j:data;
begin
        for i:=1 to m do
                begin
                        for j:=1 to n do
                                if b[i,j]=2 then
                                        write('. ')
                                else
                                write(b[i,j],' ');
                        writeln;
                end;
end;
 
procedure dem(i,j:data; var khong,mot,trong:data);
var     k,x,y:data;
begin
        khong:=0;
        mot:=0;
        for k:=1 to 4 do
                begin
                        x:=i+cld[k];
                        y:=j+clc[k];
                        if B[x,y]=0 then
                                inc(khong)
                        else
                                if b[x,y]=1 then
                                        inc(mot);
                end;
        trong:=4-khong-mot;
end;
 
procedure fill(i,j,c:data);
var     k,x,y:data;
begin 
        kt[i,j]:=true;
        for k:=1 to 4 do
                begin
                        x:=i+cld[k];
                        y:=j+clc[k];
                        if B[x,y]=2 then
                                begin
                                        B[x,y]:=c;
                                        inc(sl);
                                end;
                end;
end;
 
procedure update;
var     i,j,khong,mot,trong:data;
begin
        for i:=1 to m do
                for j:=1 to n do
                        if kt[i,j]=false then
                                begin
                                        dem(i,j,khong,mot,trong);
                                        if (a[i,j]=trong) and(khong=4-trong) then
                                                fill(i,j,1)
                                        else
                                                if trong+mot=a[i,j] then
                                                        fill(i,j,1)
                                                else
                                                        if (mot=khong+trong) and (mot=a[i,j]) then
                                                                fill(i,j,0)
                                                        else
                                                                if (mot=a[i,j]) then
                                                                        fill(i,j,0)
                                                                else
                                                                        if 4-khong=a[i,j] then
                                                                                fill(i,j,1); 
                                end;
end;
 
 
procedure duyet;
var     i,j:data;
        count:data;
begin
        sl:=0;
        repeat
                count:=sl;
                update;
        until count=sl;
        if sl=m*n then
         xuat
        else
         writeln('KHONG THE');
end;
 
 
begin
        docfile;
        duyet; 
end.
```

### d. Một số bài tập khác liên quan

* bài giải MTNTRAI spoj THPTCBT – 21697. Nông Trại
* BCLKCOUN spoj PTIT – Đếm số ao
* BCISLAND PTIT spoj – Nước biển

@see https://kienthuc24h.com/thuat-toan-loang-tren-ma-tran/