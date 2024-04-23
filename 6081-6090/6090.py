# https://codeup.kr/problem.php?id=6090

a, m, d, n = map(int, input().split())
for i in range(1, n):
    a *= m
    a += d
print(a)

# 정답
# a, m, d, n = input().split()
#
# a = int(a)
# m = int(m)
# d = int(d)
# n = int(n)
#
# for i in range(1, n) :
#   a = a*m+d
#
# print(a)
#
