# https://codeup.kr/problem.php?id=6083

r, g, b = map(int, input().split())
sum = 0
for i in range(r):
    for j in range(g):
        for k in range(b):
            print(i, j, k)
            sum += 1
print(sum)

# 정답
# r, g, b = input().split()
#
# r = int(r)
# g = int(g)
# b = int(b)
#
# for i in range(0, r) :
#   for j in range(0, g) :
#     for k in range(0, b) :
#       print(i, j, k)
#
# print(r*g*b)