# https://codeup.kr/problem.php?id=6086

n = int(input())
sum = 0
i = 1
while sum < n:
    sum += i
    i += 1
print(sum)

# 정답
# a = int(input())
# s = 0
# c = 0
#
# while True:
#     s = s + c
#     c = c + 1
#     if s >= a:
#         break
#
# print(s)
