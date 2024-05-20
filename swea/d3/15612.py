# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYOBfxwaAXsDFATW&categoryId=AYOBfxwaAXsDFATW&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2

def rotate(chess):
    res = [[''] * 8 for i in range(8)]
    for r in range(8):
        for c in range(8):
            res[r][c] = chess[8-1-c][r]
    return res

t = int(input()) + 1
for tc in range(1, t):
    chess = []
    satisfied = True
    rookCount = 0
    for i in range(8):
        chess.append(list(input()))
        rookCount += chess[i].count('O')
        # 한 행에 룩이 2개 이상이면 안됨
        if chess[i].count('O') > 1:
            satisfied = False
    # 체스판에 룩이 8개가 아니면 안됨.
    if rookCount != 8:
        satisfied = False
    # 90도 회전시켜서 다시 한 행에 룩이 2개 이상인지 확인
    rotateChess = rotate(chess)

    for i in range(8):
        if rotateChess[i].count('O') > 1:
            satisfied = False

    if satisfied:
        print('#%d'%tc, 'yes')
    else:
        print('#%d'%tc, 'no')



