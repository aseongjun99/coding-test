# https://codeup.kr/problem.php?id=6056

a, b = map(int, input().split())
print(bool(a) != bool(b))

# 정답
# a, b=input().split()
# c = bool(int(a))
# d = bool(int(b))
# print((c and (not d)) or ((not c) and d))
