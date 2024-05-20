# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PttaaAZIDFAUq&categoryId=AV5PttaaAZIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    h1, m1, h2, m2 = map(int, input().split())
    h = h1+h2
    m = m1+m2

    if m >= 60:
        h += 1
        m -= 60

    if h > 12:
        h -= 12

    print('#%d'%tc, h, m)