# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV189xUaI8UCFAZN&categoryId=AV189xUaI8UCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=3

t = int(input()) + 1
for tc in range(1, t):
    p, q, r, s, w = map(int, input().split())

    # A사 : 리터당 P원
    price_a = p * w

    # B사 : 기본 Q원, R 리터 이상 사용시 리터당 S원
    price_b = q
    if r < w:
        w -= r
        price_b += s * w

    print('#%d'%tc, min(price_a, price_b))