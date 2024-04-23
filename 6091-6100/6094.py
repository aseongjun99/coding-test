# https://codeup.kr/problem.php?id=6094

n = int(input())
num = list(map(int, input().split()))
num.sort()
print(num[0])

# 정답
# n = int(input())
# a = input().split()
#
# for i in range(n) :
#   a[i] = int(a[i])
#
# min = a[0]
# for i in range(0, n) :
#   if a[i] < min :
#     min = a[i]
#
# print(min)
#
