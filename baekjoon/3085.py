# https://www.acmicpc.net/problem/3085

def check(arr):
    count = res = 1
    for i in range(1, len(arr)):
        if arr[i] == arr[i-1]:
            count += 1
            res = max(res, count)
        else:
            count = 1
    return res

N = int(input())
candy = [list(input()) for _ in range(N)]
answer = 0
for i in range(N):
    for j in range(N):
        if j+1 != N:
            # 우측 변경
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]
            # i행, j열, j+1열 검사
            answer = max(check(candy[i]), check(list(zip(*candy))[j]), check(list(zip(*candy))[j+1]), answer)
            candy[i][j], candy[i][j + 1] = candy[i][j + 1], candy[i][j]

        if i+1 != N:
            # 하측 변경
            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]
            # i행, i+1행, j열 검사
            answer = max(check(candy[i]), check(candy[i+1]), check(list(zip(*candy))[j]), answer)
            candy[i][j], candy[i + 1][j] = candy[i + 1][j], candy[i][j]

print(answer)