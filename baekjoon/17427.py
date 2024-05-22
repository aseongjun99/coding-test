# https://www.acmicpc.net/problem/17427

n = int(input())
ans = 0

# 1~n 까지의 숫자들의 모든 약수는
# n // i 개 씩 등장한다.
# ex) 1의 경우 n개 만큼, 2의 경우 n//2개 만큼, ...
for i in range(1, n+1):
    ans += (n//i) * i

print(ans)