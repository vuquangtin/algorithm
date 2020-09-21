## Breadth\_Fist\_Search(e,s,f,n,m):

- e: là ma trận `(N+1)*(M+1)` chứa 0 và 1 trong đó 0 là có thể di chuyển vào, 1 là có chướng ngại vật.
- s: tọa độ điểm xuất phát
- f: tọa độ điểm cần đến
- n,m: kích thướt ma trận e
- Trả về
    + ma trận rỗng nếu như k tìm được đường
    + ma trận `(N+1)*(M+1)` chứa 0 và 1 trong đó 1 là ô thuộc đường đi cần tìm. 

### Ý tưởng: 
Bắt đầu từ điểm xuất phát và lần lượt nhìn các điểm kề với điểm gốc. Sau đó, với điểm đỉnh trong số đó, thuật toán lại lần lượt nhìn trước các điểm kề với nó mà chưa được quan sát trước đó và lặp lại cho tới khi tìm được điểm đến. 

### Thuật toán:
```
    B1:Chèn điểm xuất vào hàng đợi (đang hướng tới)
    B2:Lấy ra điểm đầu tiên trong hàng đợi và quan sát nó
        Nếu điểm này chính là điểm đích, dừng quá trình tìm kiếm và trả về kết quả.
        Nếu không phải thì chèn tất cả các điểm kề với điểm vừa thăm và có thể đi được nhưng chưa được quan sát trước đó vào hàng đợi.
    B3:Nếu hàng đợi là rỗng, thì tất cả các điểm có thể đến được đều đã được quan sát – dừng việc tìm kiếm và trả về "không thấy".
    B4:Nếu hàng đợi không rỗng thì quay về bước 2.
```

### Đô phức tạp: 
O(N*M)

### Breadth_First_Search.py

```python
import numpy as np

dx=[1,0,0,-1]
dy=[0,-1,1,0]
def Check_Can_Go(x,y,e,n,m):
    if(x<=0 or x>=n):
        return False
    if(y<=0 or y>=m):
        return False
    if(e[x][y]!=0): 
        return False
    return True
def TheWay(e,f,s,n,m):
    x,y=f
    t=np.full((n+1,m+1),0)
    while True:
        if((x,y)==s):
            t[x][y]=2
            return t
        t[x][y]=2
        #print(x,y)
        x,y=e[x][y]
def Breadth_First_Search(e,s,f,n,m):
    h=[]
    h.append((s,0))
    isVisit=np.full((n+1,m+1),0)
    theWay=np.full((n+1,m+1,2),0)
    while True:
        if len(h)==0: 
            return []
        x,z=h.pop(0)
        x,y=x
        if((x,y)==f):
            return TheWay(theWay,f,s,n,m)+e
        for i in range(0,4,1):
            u=dx[i]+x
            v=dy[i]+y
            t=z+1
            if(Check_Can_Go(u,v,e,n,m) and isVisit[u][v]==0):
                isVisit[u][v]=t
                h.append(((u,v),t))
                theWay[u][v]=[x,y]
```

## Two\_Side\_Search(e,s,f,n,m):
- e: là ma trận `(N+1)*(M+1)` chứa 0 và 1 trong đó 0 là có thể di chuyển vào, 1 là có chướng ngại vật.
- s: tọa độ điểm xuất phát
- f: tọa độ điểm cần đến
- n,m: kích thướt ma trận e
- Trả về
    + ma trận rỗng nếu như k tìm được đường
    + ma trận (N+1)*(M+1) chứa 0 và 1 trong đó 1 là ô thuộc đường đi cần tìm. 

### Ý tưởng: 
Bắt đầu từ điểm xuất phát và điểm đến lần lượt nhìn các điểm kề với chúng . Sau đó, với điểm đỉnh trong số đó, thuật toán lại lần lượt nhìn trước các điểm kề với nó mà chưa được quan sát trước đó và lặp lại cho tới khi tìm được đường đi từ 2 điểm gặp nhau.
### Thuật toán:
```
    B1:Chèn điểm xuất phát và kết thúc vào hàng đợi.
    B2:Lấy ra điểm đầu tiên trong hàng đợi và quan sát nó.Chèn tất cả các điểm kề với điểm vừa thăm và có thể đi được nhưng chưa được quan sát trước đó vào hàng đợi.
        Nếu có điểm kề với nó nhưng đi từ điểm bắt đầu khác nó ta trả về con đường.
    B3:Nếu hàng đợi là rỗng, thì tất cả các điểm có thể đến được đều đã được quan sát – dừng việc tìm kiếm và trả về "không thấy".
    B4:Nếu hàng đợi không rỗng thì quay về bước 2.
```

### Đô phức tạp: 
O(N*M)
### Two_Side_Search.py
```python
import numpy as np
dx=[1,0,0,-1]
dy=[0,-1,1,0]
def Check_Can_Go(x,y,e,n,m):
    if(x<=0 or x>=n):
        return False
    if(y<=0 or y>=m):
        return False
    if(e[x][y]!=0): 
        return False
    return True
def TheWay(e,f,s,n,m):
    x,y=f
    t=np.full((n+1,m+1),0)
    while True:
        if((x,y)==s):
            t[x][y]=2
            return t
        t[x][y]=2
        #print(x,y)
        x,y=e[x][y]
def Two_Side_Search(e,s,f,n,m):
    h=[]
    h.append((s,1))
    h.append((f,2))
    isVisit=np.full((n+1,m+1),0)
    isVisit[s]=1
    isVisit[f]=2
    theWay=np.full((n+1,m+1,2),0)
    while True:
        if len(h)==0: 
            return []
        x,z=h.pop(0)
        x,y=x
        for i in range(0,4,1):
            u=dx[i]+x
            v=dy[i]+y
            t=z
            if(Check_Can_Go(u,v,e,n,m)and isVisit[u][v]!=0 and isVisit[x][y]!=isVisit[u][v]):
                res=np.full((n,m),0)
                #print(isVisit[u][v])
                #print(isVisit[x][y])
                if(isVisit[x][y]==1):
                    #print(TheWay(theWay,(x,y),s,n,m))
                    #print(TheWay(theWay,(u,v),f,n,m))
                    res=TheWay(theWay,(x,y),s,n,m)+TheWay(theWay,(u,v),f,n,m)+e
                if(isVisit[x][y]==2):
                    #print(TheWay(theWay,(x,y),f,n,m))
                    #print(TheWay(theWay,(u,v),s,n,m))
                    res=TheWay(theWay,(x,y),f,n,m)+TheWay(theWay,(u,v),s,n,m)+e
                return res
            if(Check_Can_Go(u,v,e,n,m) and isVisit[u][v]==0):
                isVisit[u][v]=t
                #print(t)
                h.append(((u,v),t))
                theWay[u][v]=[x,y]


if __name__ == "__main__":
   a=np.full((18+1,19+1),0)
   t=Two_Side_Search(a,(1,1),(10,10),18,19)
   print(t)
```

## Depth\_Fist\_Search(e,s,f,n,m):
- e: là ma trận (N+1)*(M+1) chứa 0 và 1 trong đó 0 là có thể di chuyển vào, 1 là có chướng ngại vật.
- s: tọa độ điểm xuất phát
- f: tọa độ điểm cần đến
- n,m: kích thướt ma trận e
- Trả về
    + ma trận rỗng nếu như k tìm được đường
    + ma trận (N+1)*(M+1) chứa 0 và 1 trong đó 1 là ô thuộc đường đi cần tìm. 

### Ý tưởng:
khởi đầu tại điểm xuất phát và phát triển xa nhất có thể theo mỗi nhánh. Quá trình tìm kiếm được phát triển tới điểm đến cần tìm hoặc tới một nút không có con. Khi đó giải thuật quay lui về đỉnh vừa mới tìm kiếm ở bước trước.

### Thuật toán:
```
    B1: Đẩy điểm xuất phát vào ngăn xếp
    B2: Xét điểm u cuối cùng trong hàng đợi và quan sát nó
        Nếu điểm này chính là điểm đích hoặc không tồn tại điểm v kề với u có thể đi được và v chưa thăm hoặc chi phí đến v lớn hơn chi phí đến u + 1 thì xóa điểm u khỏi ngăn xếp.
        Nếu tồn tại điểm v kề với u có thể đi được và v chưa thăm hoặc chi phí đến v lớn hơn chi phí đến u + 1
        ta gán chi phí v là chi phí u +1 và đẩy v vào cuối hàng đợi và chuyển đến bước 3.
    B3: Nếu ngăn xếp không rổng chuyển đến bước 2.\
    B4: Nếu điểm đến chưa xét ta trả "không tìm được" ngược lại trả về đường từ điểm xuất phát đến điểm đích.
```
### Độ phức tạp: 
O((N*M)^2)

```python
import numpy as np

dx=[1,0,0,-1]
dy=[0,-1,1,0]
def Check_Can_Go(x,y,e,n,m):
    if(x<=0 or x>=n):
        return False
    if(y<=0 or y>=m):
        return False
    if(e[x][y]!=0): 
        return False
    return True
def TheWay(e,f,s,n,m):
    x,y=f
    t=np.full((n+1,m+1),0)
    while True:
        if((x,y)==s):
            t[x][y]=2
            return t
        t[x][y]=2
        #print(x,y)
        x,y=e[x][y]
def dfs(e,x,y,n,m,isVisit,TheWay):
    for i in range(0,4,1):
        u=x+dx[i]
        v=y+dy[i]
        if(Check_Can_Go(u,v,e,n,m) and isVisit[u][v]>isVisit[x][y]+1):
            isVisit[u][v]=isVisit[x][y]+1
            TheWay[u][v]=[x,y]
            dfs(e,u,v,n,m,isVisit,TheWay)
def Depth_First_Search(e,s,f,n,m):
    isVisit=np.full((n+1,m+1),np.inf)
    theWay=np.full((n+1,m+1,2),0)
    x,y=s
    isVisit[x][y]=0
    dfs(e,x,y,n,m,isVisit,theWay)
    x,y=f
    if(isVisit[x][y]==np.inf):
        return []
    return TheWay(theWay,f,s,n,m)+e
```

## K\_Place\_Search(e,n,m,listPlace,s,f):
- e: là ma trận (N+1)*(M+1) chứa 0 và 1 trong đó 0 là có thể di chuyển vào, 1 là có chướng ngại vật.
- n,m: kích thướt ma trận e
- lishPlace: danh sách cách địa điểm cần đi qua các điểm này khác điểm xuất phát và kết thúc. 
- s: tọa độ điểm xuất phát
- f: tọa độ điểm cần đến
- Trả về
    + ma trận rỗng nếu như k tìm được đường
    + ma trận (N+1)*(M+1) chứa 0 và 1 trong đó 1 là ô thuộc đường đi cần tìm.

### Ý tưởng: 
Bắt đầu từ điểm xuất phát và lần lượt nhìn các điểm kề với điểm gốc. Sau đó, với điểm đỉnh trong số đó, thuật toán lại lần lượt nhìn trước các điểm kề với nó mà chưa được quan sát trước đó và lặp lại cho tới khi tìm được điểm đến. 
### Thuật toán:
```
    B1:Chèn điểm xuất vào hàng đợi (đang hướng tới)
    B2:Lấy ra điểm đầu tiên trong hàng đợi và quan sát nó
        Nếu điểm này chính là điểm đích và đi qua các điểm cần đến, dừng quá trình tìm kiếm và trả về kết quả.
        Nếu không phải thì chèn tất cả các điểm kề với điểm vừa thăm và có thể đi được nhưng chưa được quan sát trước đó vào hàng đợi. 
            Nếu điểm đó là điểm cần đi qua thì đánh dấu trạng thái đã đi qua điểm đó.
    B3:Nếu hàng đợi là rỗng, thì tất cả các điểm có thể đến được đều đã được quan sát – dừng việc tìm kiếm và trả về "không thấy".
    B4:Nếu hàng đợi không rỗng thì quay về bước 2.
```
### Đô phức tạp: 
O(N*M*2^K)

```python

import numpy as np
dx=[1,0,0,-1]
dy=[0,-1,1,0]
def setKthBit(n,k): 
    return ((1 << k) | n) 

def Check_Can_Go(x,y,e,n,m):
    if(x<=0 or x>=n):
        return False
    if(y<=0 or y>=m):
        return False
    if(e[x][y]!=0): 
        return False
    return True
def TheWay(theWay,f,s,n,m,k,c,e,listPlace):
    x,y=f
    z=k
    #print(k)
    t=np.full((c+1,n+1,m+1),0)
    while True:
        t[c]=e
        if(c==0):
            t[c][x][y]=2
            return t
        t[c][x][y]=2
        if(x,y)in listPlace:
            e[x][y]=6
            #print(e)
        #print(t[c])
        #print(x,y)
        c=c-1
        x,y,z=theWay[x][y][z]
def K_Place_Search(e, s,f,n,m,listPlace):
    placeCount=len(listPlace)
    k=int(pow(2,placeCount))-1
    #print(k)
    h=[]
    h.append((s,0,0))
    isVisit=np.full((n+1,m+1,k+1),0)
    theWay=np.full((n+1,m+1,k+1,3),0)
    while True:
        if len(h)==0: 
            return []
        x,z,t=h.pop(0)
        x,y=x
        if((x,y)==f and t==k):
            return TheWay(theWay,f,s,n,m,k,z,e,listPlace)
            #return "Find the way"
        for i in range(0,4,1):
            u=dx[i]+x
            v=dy[i]+y
            c=z+1
            d=t
            for j in range(0,placeCount,1):
                #print(listPlace[j])
                if(listPlace[j]==(u,v)):
                    #print("aa1")
                    d=setKthBit(d,j)
                    #print(j,d)
            if(Check_Can_Go(u,v,e,n,m) and isVisit[u][v][d]==0):
                #print(u,v,d)
                isVisit[u][v][d]=c
                h.append(((u,v),c,d))
                theWay[u][v][d]=[x,y,t]
```

## Moving\_Search(e,s,f,n,m):
- e: là ma trận (N+1)*(M+1) chứa 0 và 1 trong đó 0 là có thể di chuyển vào, 1 là có chướng ngại vật.
- s: tọa độ điểm xuất phát
- f: tọa độ điểm cần đến
- n,m: kích thướt ma trận e
- Trả về
    + ma trận rỗng nếu như k tìm được đường
    + ma trận (C+1)(N+1)*(M+1) trong đó với mỗi ma trận 0<=i<=C là một ma trận 2 chiều là trạng thái của bước i trong cách đi tốt nhất

### Ý tưởng: 
Bắt đầu từ điểm xuất phát và lần lượt nhìn các điểm kề với điểm gốc. Sau đó, với điểm đỉnh trong số đó, thuật toán lại lần lượt nhìn trước các điểm kề với nó mà chưa được quan sát trước đó và lặp lại cho tới khi tìm được điểm đến. 
### Thuật toán:
```
    B1:Chèn điểm xuất vào hàng đợi (đang hướng tới)
    B2:Lấy ra điểm đầu tiên trong hàng đợi và quan sát nó
        Nếu điểm này chính là điểm đích, dừng quá trình tìm kiếm và trả về kết quả.
        Nếu không phải thì chèn tất cả các điểm kề với điểm vừa thăm và có thể đi được nhưng chưa được quan sát trước đó vào hàng đợi.
    B3:Nếu hàng đợi là rỗng, thì tất cả các điểm có thể đến được đều đã được quan sát – dừng việc tìm kiếm và trả về "không thấy".
    B4:Nếu hàng đợi không rỗng thì quay về bước 2.
```
### Đô phức tạp:
 O(N*M*2)
 
```python
import numpy as np
dx=[1,0,0,-1,0]
dy=[0,-1,1,0,0]
def Check_Can_Go(x,y,e,n,m):
    if(x<=0 or x>=n):
        return False
    if(y<=0 or y>=m):
        return False
    if(e[x][y]!=0): 
        return False
    return True
def Moving(e,n,m):
    e1=np.full((n+1,m+1),0)
    #print(e)
    for i in range(1,n,1):
        for j in range(1,m,1):
            if(e[i][j]!=0):
                t=e[i][j]-10
                print(t)
                e1[i+dx[t]][j+dy[t]]=e[i][j]
    #print(e1)
    return e1
def TheWay(theWay,f,s,n,m,e,e1,c):
    x,y=f
    t=np.full((c+1,n+1,m+1),0)
    while True:
        if((x,y)==s):
            #print(c)
            if(c%2==0):
                t[c]=e
            else: 
                t[c]=e1    
            t[c][x][y]=2
            #print(t[0])
            return t
        if(c%2==0):
           t[c]=e
        else: 
            t[c]=e1    
        t[c][x][y]=2
        #print(t[c])
        c=c-1
        #print(x,y)
        x,y=theWay[x][y]
     
def Moving_Search(e,s,f,n,m):
    #print(e)
    e1=Moving(e,n,m)
    #print(e)
    #print(e1)
    h=[]
    h.append((s,0))
    isVisit=np.full((n+1,m+1),0)
    theWay=np.full((n+1,m+1,2),0)
    while True:
        if len(h)==0: 
            return []
        x,z=h.pop(0)
        x,y=x
        if((x,y)==f):
            return TheWay(theWay,f,s,n,m,e,e1,z)
        for i in range(0,5,1):
            u=dx[i]+x
            v=dy[i]+y
            t=z+1
            check=0
            if(t%2==0):
                check=Check_Can_Go(u,v,e,n,m)
            else: 
                check=Check_Can_Go(u,v,e1,n,m)
            if(check==1 and isVisit[u][v]==0):
                isVisit[u][v]=t
                h.append(((u,v),t))
                theWay[u][v]=[x,y]  
```