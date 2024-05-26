# https://www.acmicpc.net/problem/1107

N = int(input())
M = int(input())
broken = []
if M != 0:
    broken = list(map(int, input().split()))

mn = abs(N - 100)
for i in range(500001):
    check = True
    for j in range(len(broken)):
        if str(broken[j]) in str(i):
            check = False
            break

    if check:
        mn = min(mn, abs(N-i) + len(str(i)))

print(mn)