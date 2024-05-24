# https://www.acmicpc.net/problem/1929
import math

M, N = map(int, input().split())
answer = []
for i in range(M, N+1):
    if i == 1:
        continue
    count = 0
    for j in range(2, int(math.sqrt(i))+1):
        if i % j == 0:
            count += 1
            break
    if count == 0:
        answer.append(i)

for ans in answer:
    print(ans)