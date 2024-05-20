# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYEXgKnKKg0DFARx&categoryId=AYEXgKnKKg0DFARx&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n, m = map(int, input().split())
    board = [list(input()) for i in range(n)]

    possible1 = True
    possible2 = True

    # 좌표 값 합이 짝수 = #, 홀수 = . 가 가능한지 체크
    for i in range(n):
        for j in range(m):
            if (i+j) % 2 == 0:
                if board[i][j] != '#' and board[i][j] != '?':
                    possible1 = False
                    break
            else:
                if board[i][j] != '.' and board[i][j] != '?':
                    possible1 = False
                    break
        if not possible1:
            break

    # 좌표 값 합 짝수 = ., 홀수 = # 가능한지 체크
    for i in range(n):
        for j in range(m):
            if (i+j) % 2 == 0:
                if board[i][j] != '.' and board[i][j] != '?':
                    possible2 = False
                    break
            else:
                if board[i][j] != '#' and board[i][j] != '?':
                    possible2 = False
                    break
        if not possible2:
            break

    if possible1 or possible2:
        print('#%d'%tc, 'possible')
    else:
        print('#%d'%tc, 'impossible')