# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYYAGCNKPgIDFARc&categoryId=AYYAGCNKPgIDFARc&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2
import math

def isPrime(num):
    for i in range(2, int(math.sqrt(num))+1):
        if num % i == 0:
            return False
    return True

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    num = 2
    for i in range(1, 10000001):
        if not isPrime(num) and not isPrime(num + n):
            break
        num += 1

    print('#%d'%tc, num + n, num)
