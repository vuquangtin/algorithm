# [Pascal] Giải một số thuật toán bằng Đệ Qui

## Đảo ngược một số nguyên:

Ví dụ: 

```
Input:                                12345

Output:                               54321 
```

```pascal
program Dao_so_dung_DE_QUI;
uses crt;
procedure Dao_so(n: integer);
  begin
   if n > 0 then 
    begin
     write(n mod 10);
     Dao_so(n div 10);
     
    end;
  end;
  var n:integer;
  begin
   write('Nhap so thap phan: ');readln(n);
   Dao_so(n);
   readln;
  end.
```

## Đổi số thập phân sang số nhị phân

```
Input:                    2008

Output:                 11111011000
```

```pascal
program Doi_Thap_Phan_sang_Nhi_Phan_dung_DE_QUI;
uses crt;
procedure Doi_NP(n: integer);
  begin
   if n > 0 then 
    begin
     Doi_NP(n div 2);
     write(n mod 2);
    end;
  end;
  var n:integer;
  begin
   write('Nhap so thap phan: ');readln(n);
   Doi_NP(n);
   readln;
  end.
```

## Đảo ngược một chuỗi

```
Input:            www.thoiso.com

Output:          moc.osioht.www  
```

```pascal
uses crt;
var s:string;
function DAO_CHUOI(s:string):string;
  begin
   if (length(s) <= 0) then DAO_CHUOI:= s
   else
    DAO_CHUOI:= s[length(s)] + DAO_CHUOI(copy(s,1,length(s)-1));
  end;

begin
  clrscr;
  Writeln('CHUONG TRINH DAO NGUOC CHUOI DUNG GIAI THUAT DE QUI');
  write('Nhap chuoi can dao: ');readln(s);
  writeln('Chuoi dao nguoc la:  ',DAO_CHUOI(s));
END.
```

## Tìm số lớn nhất trong một dãy số

```
Input:                           0 4 0 2 1 9 8 5

Ouput:                          9  
```

```pascal
program Tinh_MAX_day_so_dung_Giai_Thuat_De_Qui;
uses crt;
TYPE dayso = array[1..100] of Integer;
function Max(len:integer;ds:dayso):integer;
begin
  if len= 1 then Max:= ds[len]
  else if ds[len] > Max(len -1,ds) then max:= ds[len]
   else Max:=Max(len -1,ds);
end;

var n,i:Integer;
  ds:dayso;
begin
  write('Day co bao nhieu phan tu: ');readln(n);
  for i:=1 to n do
   begin
    write('Nhap phan tu thu ',i,': ');readln(ds)
   end;
  writeln(Max(n,ds));
  readln;
end.
```

## Tính dữ liệu lớn

[Pascal] Tính 2^2008!

Với các kiểu dữ liệu số hiện có của các ngôn ngữ lập trình hiện nay thì việc tính toán không vượt quá ngưỡng 18.446.744.073.709.551.616! 

Vậy ta có thể tính 22008 được không? 

Câu trả lời là có. Tuy nhiên ta không dùng kiểu số mà dùng mảng để chứa kết quả tính toán. 

```
Input: 

               22008

Output: 

293921457990209158203605299501486587909713331
734705971322276540627396162916446800347304828
497025605099122166947580790470002462453980942
164845038427178663215460172772211999436801763
274619494514870858053094562524786640935586934
754211705131586663593866165516791188895740950
898251790395677822812580408244051664241072407
000213774342091481108259990786393027841098246
954768962126136340818524880106908845781292048
893428214830405175756437514347929224149123944
676950789355316620691925989560420249809810474
574291853773889494338599752572893233746059542
823106006739520449114953730106477493293991561
63119321894151520256 
```

Length: 605

```pascal

uses crt;
    const n=10000;
var a,x,i,j,k,temp:integer;
    du,ng:integer;
   kq:array[1..n] of integer;
    BEGIN
    clrscr;
            write('Nhap a = ');readln(a);
            write('Nhap x  = ');readln(x);
            i:=n;
            for j:=1 to i do
             kq[j]:=-1;
             kq:= a;
             ng:=0;
            while (x>1) do
              begin
              i:=n;
              while (kq<>-1) do
               begin
                 temp:=kq*a+ng;
                   du:=temp mod 10;
                   ng:=temp div 10;
                   kq:=du;
                  i:=i-1;
               end;
                if ng<>0 then
               kq:=ng;
               ng:=0;
              x:=x-1;
             end;
        i:=n;
      k:=0;
    for j:=1 to n do
        begin
        if kq[j]<>-1 then
        begin
       write(kq[j]);
       k:=k+1;
       end;
       i:=i-1;
   end;
   writeln;
   writeln('Tong cong:',k ,' chu so');
        readln;
    END.
```

# Đồ thị
## [PASCAL]Thuật toán Dijkstra tìm đường đi ngắn nhất

Thuật toán Dijkstra tìm đường đi ngắn nhất từ đỉnh S trong đồ thị có hướng, có trọng số:

- Bước 1: Khởi tạo
Với mọi đỉnh v, gọi nhãn d[v] là độ dài đường đi ngắn nhất từ S tới v.Ban đầu, d[v] được khởi gán bằng c[S,v]. Nhãn của mỗi đỉnh có hai trạngthái tự do hay cố định, nhãn tự do có nghĩa là có thể tối ưu hơn đượcnữa, nhãn cố định là không thể tối ưu hơn, giá trị của nhãn cố định chota độ dài đường đi ngắn nhất từ S đến đỉnh đó. Để tiện cài đặt, ta dùngmột mảng đánh dấu Free[v] = TRUE hay FALSE tuỳ theo D[v] tự do hay cốđịnh. Ban đầu các nhãn đều tự do. 

- Bước 2: Lặp
 -   1. Cố định nhãn: Chọn trong các đỉnh có nhãn tự do, lấy ra đỉnh u là đỉnh có giá trị nhãn nhỏ nhất, và cố định nhãn u. 
 -   2. Sửa nhãn: Dùng đỉnh u, xét tất cả những đỉnh v và sửa lại các d[v] theo công thức:<br/>
             ```d[v] := min (  d[v]      ,     d + c[u,v]   )```<br/>
Bước lặp kết thúc khi mà tất cả các nhãn được cố định hay khi đỉnh Fđược cố định nhãn (tuỳ theo ý định tìm tất cả các đường đi ngắn nhất từS hay chỉ tìm đường đi ngắn nhất từ S đến F). 

## Cài đặt

```pascal
program Shortest_Path_by_Dijkstra;
const
 max = 100;
 maxC = 10000;
var
 c: array[1..max, 1..max] of Integer;
 d: array[1..max] of Integer;
 Trace: array[1..max] of Integer;
 Free: array[1..max] of Boolean;
 n, S, F: Integer;
 
procedure LoadGraph;
var
 i, m: Integer;
 u, v: Integer;
begin
 Readln(n, m, S, F);
 for u := 1 to n do
   for v := 1 to n do
  if u = v then c[u, v] := 0 else c[u, v] := maxC;
 for i := 1 to m do Readln(u, v, c[u, v]);
end;
 
procedure Init;
var
 i: Integer;
begin
 for i := 1 to n do
   begin
  d := c[S, i];
    Trace := S;
    end;
  FillChar(Free, SizeOf(Free), True);
end;
 
procedure Dijkstra;
var
  i, u, v: Integer;
  min: Integer;
begin
  repeat
    u := 0; min := maxC;
    for i := 1 to n do
    if Free and (d < min) then
      begin
       min := d;
       u := i;
      end;
    if (u = 0) or (u = F) then Break;
    Free := False;
    for v := 1 to n do
    if Free[v] and (d[v] > d + c[u, v]) then
      begin
       d[v] := d + c[u, v];
       Trace[v] := u;
      end;
  until False;
end;
 
procedure PrintResult;
begin
  if d[F] = maxC then
    Writeln('Not found any path from ', S, ' to ', F)
  else
    begin
    Writeln('Distance from ', S, ' to ', F, ': ', d[F]);
    while F <> S do
      begin
       Write(F, '<-');
       F := Trace[F];
      end;
    Writeln(S);
    end;
end;
 
begin
  Assign(Input, 'MINPATH.INP'); Reset(Input);
  Assign(Output, 'MINPATH.OUT'); Rewrite(Output);
  LoadGraph;
  Init;
  Dijkstra;
  PrintResult;
  Close(Input);
  Close(Output);
end
```
 
 
 
