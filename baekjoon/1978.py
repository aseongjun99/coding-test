# https://www.acmicpc.net/problem/1978
import math

N = int(input())
nums = list(map(int, input().split()))
answer = 0
for num in nums:
    if num == 1:
        continue
    count = 0
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            count += 1
            break
    if count == 0:
        answer += 1

print(answer)