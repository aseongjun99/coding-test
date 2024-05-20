# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXsEBlLqedsDFARX&categoryId=AXsEBlLqedsDFARX&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    a, b = map(int, input().split())
    if 24 > (a+b):
        print('#%d'%tc, a+b)
    else:
        print('#%d'%tc, (a+b)-24)