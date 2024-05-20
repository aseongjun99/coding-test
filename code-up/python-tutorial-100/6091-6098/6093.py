# https://codeup.kr/problem.php?id=6093

n = int(input())
num = list(map(int, input().split()))

for i in range(n-1, -1, -1):
    print(num[i], end=' ')

# 정답
# n = int(input())
# a = input().split()
#
# for i in range(n) :
#   a[i] = int(a[i])
#
# for i in range(n-1, -1, -1):
#   print(a[i], end=' ')
#
