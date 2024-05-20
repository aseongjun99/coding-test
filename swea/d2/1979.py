# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PuPq6AaQDFAUq&categoryId=AV5PuPq6AaQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1&&&&&&&&&&

t = int(input()) + 1
for tc in range(1, t):
    # 입력
    n, k = map(int, input().split())
    # 퍼즐 입력
    puzzle_row = []
    puzzle_col = ['' for i in range(n)]
    answer = 0
    for i in range(n):
        puzzle_row.append(input().replace(' ', ''))
        for j in range(n):
            puzzle_col[j] += puzzle_row[i][j]

    # 연속된 1의 길이가 k여야 함.
    # 0으로 split
    for i in range(n):
        # 가로
        row = puzzle_row[i].split('0')
        # 세로
        col = puzzle_col[i].split('0')

        # 0을 기준으로 나누면, 연속으로 이어진 1만 남음.
        # 1의 개수가 k개이면 answer += 1
        for r in row:
            if r.count('1') == k:
                answer += 1
        for c in col:
            if c.count('1') == k:
                answer += 1

    print('#%d'%tc, answer)