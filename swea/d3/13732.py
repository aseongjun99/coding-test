# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AX8BAN1qTwoDFARO&categoryId=AX8BAN1qTwoDFARO&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    arr = [list(input()) for i in range(n)]
    yes = True
    # #의 시작 좌표, 끝 좌표를 알아야 한다.
    startX, startY = -1, -1
    endX, endY = -1, -1

    for i in range(n):
        for j in range(n):
            if arr[i][j] == '#':
                startY, startX = i, j
                break
        if startX != -1:
            break

    for i in range(n-1, -1, -1):
        for j in range(n-1, -1, -1):
            if arr[i][j] == '#':
                endY, endX = i, j
                break
        if endX != -1:
            break

    # 정사각형 모양이 안되면 False
    if endX - startX != endY - startY:
        yes = False

    # start~end 사이의 좌표값이 #이 아니면 안됨.
    for i in range(startY, endY+1):
        for j in range(startX, endX+1):
            if arr[i][j] != '#':
                yes = False
                break
        if not yes:
            break

    if yes:
        print('#%d'%tc, 'yes')
    else:
        print('#%d'%tc, 'no')
