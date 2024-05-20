# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXb6LR76vCcDFARR&categoryId=AXb6LR76vCcDFARR&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    d, l, n = map(int ,input().split())
    answer = 0
    for i in range(n):
        answer += d * (1 + i * (l * 0.01))
    print('#%d'%tc, int(answer))