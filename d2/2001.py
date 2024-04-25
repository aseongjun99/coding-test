# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

T = int(input()) + 1
for tc in range(1, T):
    # 입력
    N, M = map(int, input().split())
    board = []
    for i in range(N):
        board.append(list(map(int, input().split())))

    # 파리채의 시작 좌표가 (x, y)일 때,
    # x, y의 값은 (0, 0) ~ (N-M, N-M)
    max_num = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            num = 0
            # 파리채 크기만큼 합 구하기
            for k in range(M):
                num += sum(board[i+k][j:j+M])
            if max_num < num:
                max_num = num
    print('#%d'%tc, max_num)
