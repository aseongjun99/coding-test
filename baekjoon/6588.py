# https://www.acmicpc.net/problem/6588
import math
import sys

MAX = 1000001
primes = [True] * MAX
for i in range(2, int(MAX**0.5)+1):
    if primes[i]:
        for j in range(i*i, MAX, i):
            primes[j] = False
while True:
    n = int(sys.stdin.readline())
    # 입력 마지막 줄 0
    if n == 0:
        break

    # 가장 작은 홀수 소수 = 3
    # 범위 내 가장 큰 홀수 = n - 3 (n == 짝수이고, 더하는 가장 작은 홀수가 3이므로)
    for i in range(3, n-2, 2):
        if primes[i] and primes[n-i]:
            print(f'{n} = {i} + {n-i}')
            break
    else:
        print("Goldbach's conjecture is wrong.")