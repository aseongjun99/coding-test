# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PpoFaAS4DFAUq&categoryId=AV5PpoFaAS4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    max_num = 0
    if n > m:
        for i in range(n-m+1):
            sum = 0
            for j in range(m):
                sum += b[j] * a[i+j]
            if sum > max_num:
                max_num = sum
    else:
        for i in range(m-n+1):
            sum = 0
            for j in range(n):
                sum += a[j] * b[i + j]
            if sum > max_num:
                max_num = sum

    print('#%d'%tc, max_num)