# https://codeup.kr/problem.php?id=6091

a, b, c = map(int, input().split())
d = 1
while d%a != 0 or d%b != 0 or d%c != 0:
    d += 1
print(d)

# 정답
# a, b, c = input().split()
#
# a = int(a)
# b = int(b)
# c = int(c)
#
# d = 1
# while d%a!=0 or d%b!=0 or d%c!=0 :
#   d += 1
#
# print(d)
#
