# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXgZSOn6ApIDFASW&categoryId=AXgZSOn6ApIDFASW&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    s = input()
    a, b = 1, 1
    for c in s:
        if c == 'R':
            a += b
        else:
            b += a

    print('#%d'%tc, a, b)