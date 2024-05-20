# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYcllbDqUVgDFASR&categoryId=AYcllbDqUVgDFASR&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())

    answer = 0

    # 제 1사분면
    for x in range(1, n):
        for y in range(1, n):
            if n*n >= (x*x + y*y):
                answer += 1
    # 나머지 사분면
    answer *= 4
    # 원점
    answer += 1
    # 축
    answer += n*4

    print('#%d'%tc, answer)