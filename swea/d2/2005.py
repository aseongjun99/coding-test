# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

T = int(input()) + 1
for tc in range(1, T):
    N = int(input())
    print('#%d'%tc)
    num = [[1], [1, 1]]
    for i in range(2, N):
        temp = []
        for j in range(i+1):
            if j == 0 or j == i:
                temp.append(1)
            else:
                temp.append(num[i-1][j-1] + num[i-1][j])
        num.append(temp)
    for i in range(N):
        for j in range(len(num[i])):
            print(num[i][j], end=' ')
        print()