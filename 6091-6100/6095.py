# https://codeup.kr/problem.php?id=6095

board = []
for i in range(19):
    temp = []
    for j in range(19):
        temp.append(0)
    board.append(temp)
n = int(input())
for i in range(n):
    x, y = map(int, input().split())
    board[x-1][y-1] = 1
for i in range(19):
    for j in range(19):
        print(board[i][j], end=' ')
    print()

# 정답
# d=[]
# for i in range(20) :
#   d.append([])
#   for j in range(20) :
#     d[i].append(0)
#
# n = int(input())
# for i in range(n) :
#   x, y = input().split()
#   d[int(x)][int(y)] = 1
#
# for i in range(1, 20) :
#   for j in range(1, 20) :
#     print(d[i][j], end=' ')
#   print()
#
#

