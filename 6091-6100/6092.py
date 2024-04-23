# https://codeup.kr/problem.php?id=6092

n = int(input())
count = [0] * 24
num = list(map(int, input().split()))
for i in num:
    count[i] += 1
for i in range(1, len(count)):
    print(count[i], end=' ')

# 정답
# n = int(input())
# a = input().split()
#
# for i in range(n) :
#   a[i] = int(a[i])
#
# d = []
# for i in range(24) :
#   d.append(0)
#
# for i in range(n) :
#   d[a[i]] += 1
#
# for i in range(1, 24) :
#   print(d[i], end=' ')
#
