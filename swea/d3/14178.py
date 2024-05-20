# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AX_N3oSqcyUDFARi&categoryId=AX_N3oSqcyUDFARi&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n, d = map(int, input().split())
    # 분무기는 대상 칸 및 양 옆으로 d만큼 가능
    spray = 1 + (d*2)

    if n % spray == 0:
        print('#%d'%tc, n//spray)
    else:
        print('#%d'%tc, n//spray+1)
