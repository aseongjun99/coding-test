# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXuUo_Tqs9kDFARa&categoryId=AXuUo_Tqs9kDFARa&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
answer = []
for tc in range(1, t):
    a, b, c, d = map(int, input().split())
    time = 0
    # 한 번도 겹치지 않음
    if b <= c or d <= a:
        time = 0
    elif b <= d:
        if a < c:
            time = b - c
        else:
            time = b - a
    elif d < b:
        if a < c:
            time = d - c
        else:
            time = d - a
    answer.append(time)
# 시간 초과로 인해 출력을 따로 해야 한다고 한다.
for i in range(len(answer)):
    print('#%d'%(i+1), answer[i])
