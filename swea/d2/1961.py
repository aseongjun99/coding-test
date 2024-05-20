# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

def rotate(matrix):
    res = [[0] * len(matrix) for _ in range(len(matrix))]
    for x in range(len(res)):
        for y in range(len(res)):
            res[x][y] = matrix[len(matrix)- y - 1][x]

    return res


t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    # 행렬 입력
    matrix = []
    for i in range(n):
        matrix.append(list(map(int, input().split())))

    rotated_90 = rotate(matrix)
    rotated_180 = rotate(rotated_90)
    rotated_270 = rotate(rotated_180)
    result = [[] for _ in range(n)]

    for i in range(n):
        result[i].append(rotated_90[i])
        result[i].append(rotated_180[i])
        result[i].append(rotated_270[i])

    print('#%d'%tc)
    for i in range(len(result)):
        for j in range(len(result[i])):
            for k in range(len(result[i][j])):
                print(result[i][j][k], end='')
            print(end=' ')
        print()

