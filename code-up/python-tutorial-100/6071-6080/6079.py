# https://codeup.kr/problem.php?id=6079

n = int(input())
sum = 0
i = 1
while n > sum:
    sum += i
    i += 1
print(i-1)

# 정답
# n = int(input())
#
# s = 0
# t = 0
# while s < n:
#     t = t + 1
#     s = s + t
#
# print(t)
#
