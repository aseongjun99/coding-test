# https://codeup.kr/problem.php?id=6089

a, r, n = map(int, input().split())
print(a * (r**(n-1)))

# 정답
# a, r, n = input().split()
#
# a = int(a)
# r = int(r)
# n = int(n)
#
# for i in range(1, n) :
#   a = a*r
#
# print(a)
#
