# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYj_Dz-6qLgDFASl&categoryId=AYj_Dz-6qLgDFASl&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    a, b = map(int, input().split())
    diff = abs(a - b)

    if diff == 1 or a > b:
        print('#%d'%tc, -1)
    else:
        print('#%d'%tc, diff//2)