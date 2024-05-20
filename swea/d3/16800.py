# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYaf9W8afyMDFAQ9&categoryId=AYaf9W8afyMDFAQ9&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2
import math

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())

    a, b = 0, 0
    for i in range(1, int(math.sqrt(n))+1):
        if n % i == 0:
            a, b = i, n//i

    answer = a-1 + b-1

    print('#%d'%tc, answer)
