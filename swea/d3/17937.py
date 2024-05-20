# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYmRI_8ajv8DFARi&categoryId=AYmRI_8ajv8DFARi&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    a, b = map(int, input().split())
    if a == b:
        print('#%d'%tc, a)
    else:
        print('#%d'%tc, 1)
