# https://www.acmicpc.net/problem/2609
import math

def gcd(a, b):
    while b > 0:
        a, b = b, a%b
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

a, b = map(int, input().split())
a, b = max(a, b), min(a, b)
# num = math.gcd(a,b)
# num2 = math.lcm(a,b)
num = gcd(a, b)
num2 = lcm(a, b)

print(num)
print(num2)