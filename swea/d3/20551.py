# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AY4XhKTKU0IDFARM&categoryId=AY4XhKTKU0IDFARM&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    a, b, c = map(int, input().split())
    # c < 3 이면 조건을 충족시킬 수 없음
    # b < 2 이여도 마찬가지
    sum = 0
    if c < 3 or b < 2:
        sum = -1
    else:
        if b >= c:
            sum += b - c + 1
            b = c - 1
        if a >= b:
            sum += a - b + 1
    print('#%d'%tc, sum)