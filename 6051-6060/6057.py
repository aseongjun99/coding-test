# https://codeup.kr/problem.php?id=6057

a, b = map(int, input().split())

print(bool(a) == bool(b))

# 정답 1
# a, b = input().split()
# a = bool(int(a))
# b = bool(int(b))
# print((a and b) or (not a and not b))
#
# 정답 2
# a, b = input().split()
# a = bool(int(a))
# b = bool(int(b))
# print(a==b)
