# https://codeup.kr/problem.php?id=6098

maze = []
for i in range(10):
    maze.append(list(map(int, input().split())))

x, y = 1, 1
while True:
    if maze[x][y] == 2:
        maze[x][y] = 9
        break
    maze[x][y] = 9
    if maze[x][y+1] == 1:
        if maze[x+1][y] == 1:
            break
        else:
            x += 1
    else:
        y+=1

for i in range(10):
    for j in range(10):
        print(maze[i][j], end=' ')
    print()


# 정답
# m = []
# for i in range(12):
#     m.append([])
#     for j in range(12):
#         m[i].append(0)
#
# for i in range(10):
#     a = input().split()
#     for j in range(10):
#         m[i + 1][j + 1] = int(a[j])
#
# x = 2
# y = 2
# while True:
#     if m[x][y] == 0:
#         m[x][y] = 9
#     elif m[x][y] == 2:
#         m[x][y] = 9
#         break
#
#     if (m[x][y + 1] == 1 and m[x + 1][y] == 1) or (x == 9 and y == 9):
#         break
#
#     if m[x][y + 1] != 1:
#         y += 1
#     elif m[x + 1][y] != 1:
#         x += 1
#
# for i in range(1, 11):
#     for j in range(1, 11):
#         print(m[i][j], end=' ')
#     print()
#
