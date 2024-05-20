# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pl0Q6ANQDFAUq&categoryId=AV5Pl0Q6ANQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    a,b,c,d,e = 0,0,0,0,0

    while True:
        if n % 2 == 0:
            n /= 2
            a += 1
        elif n % 3 == 0:
            n /= 3
            b += 1
        elif n % 5 == 0:
            n /= 5
            c += 1
        elif n % 7 == 0:
            n /= 7
            d += 1
        elif n % 11 == 0:
            n /= 11
            e += 1
        else:
            break

    print('#%d'%tc, a, b, c, d, e)