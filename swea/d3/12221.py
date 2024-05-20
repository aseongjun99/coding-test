# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXpz3dravpQDFATi&categoryId=AXpz3dravpQDFATi&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    a, b = map(int, input().split())
    if a >= 10 or b >= 10:
        print('#%d'%tc, -1)
    else:
        print('#%d'%tc, a*b)