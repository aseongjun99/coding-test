# https://codeup.kr/problem.php?id=6088

a, d, n = map(int, input().split())
for i in range(1, n):
    a += d
print(a)
# print(a + d * (n-1))

# 정답
# a, d, n = input().split()
#
# a = int(a)
# d = int(d)
# n = int(n)
#
# s = a
# for i in range(2, n + 1):
#     s += d
#
# print(s)
#
