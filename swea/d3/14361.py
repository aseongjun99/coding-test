# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYCnY9Kqu6YDFARx&categoryId=AYCnY9Kqu6YDFARx&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1
from itertools import permutations

t = int(input()) + 1
for tc in range(1, t):
    possible = False
    n = int(input())
    nStringSplit = list(str(n))
    nArray = list(permutations(nStringSplit,len(nStringSplit)))
    for i in range(len(nArray)):
        nArray[i] = int(''.join(nArray[i]))

    for num in nArray:
        if int(num) == n:
            continue
        if int(num) % n == 0:
            possible = True

    if possible:
        print('#%d'%tc, 'possible')
    else:
        print('#%d'%tc, 'impossible')

