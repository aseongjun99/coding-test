# https://codeup.kr/problem.php?id=6097

h, w = map(int, input().split())
n = int(input())
board = []
for i in range(h):
    board.append([])
    for j in range(w):
        board[i].append(0)

for i in range(n):
    l, d, x, y = map(int, input().split())
    for j in range(l):
        if d == 0:
            board[x-1][y-1+j] = 1
        else:
            board[x-1+j][y-1] = 1

for i in range(h):
    for j in range(w):
        print(board[i][j], end=' ')
    print()

# 정답
# h,w = input().split()
# h = int(h)
# w = int(w)
#
# m = []
# for i in range(h+1) :
#   m.append([])
#   for j in range(w+1) :
#     m[i].append(0)
#
# n = int(input())
# for i in range(n) :
#   l,d,x,y = input().split()
#   if int(d)==0 :
#     for j in range(int(l)) :
#       m[int(x)][int(y)+j] = 1
#   else :
#     for j in range(int(l)) :
#       m[int(x)+j][int(y)] = 1
#
# for i in range(1, h+1) :
#   for j in range(1, w+1) :
#     print(m[i][j], end=' ')
#   print()
#
