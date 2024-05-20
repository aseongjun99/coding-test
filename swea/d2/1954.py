# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1

# 우, 하, 좌, 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
snail = []
visit = []

def move(x, y, check, dir):
    visit[x][y] = 1
    snail[x][y] = check
    check += 1

    for i in range(4):
        nd = (dir + i)  % 4
        nx = x + dx[nd]
        ny = y + dy[nd]
        # 범위 체크
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        # 방문 여부 체크
        if visit[nx][ny] == 1:
            continue
        move(nx, ny, check, nd)


for tc in range(1,t):
    n = int(input())
    snail = [[0] * n for i in range(n)]
    visit = [[0] * n for i in range(n)]
    move(0, 0, 1, 0)
    print('#%d'%tc)
    for i in range(len(snail)):
        for j in range(len(snail[i])):
            print(snail[i][j], end=' ')
        print()
