# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXmwMidaSLIDFARX&categoryId=AXmwMidaSLIDFARX&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n, pd, pg = map(int, input().split())
    possible = False
    # 확률이 정수로 떨어지는지 확인
    for i in range(1, n+1):
        if i * pd / 100 == int(i*pd/100):
            possible = True
            break
    # 오늘 1판 이상 졌는데 전체 승률 100인 경우
    if pd != 100 and pg == 100:
        possible = False
    # 오늘 승률 100인데 전체 승률 0인 경우
    if pd != 0 and pg == 0:
        possible = False

    if possible:
        print('#%d'%tc, 'Possible')
    else:
        print('#%d'%tc, 'Broken')
