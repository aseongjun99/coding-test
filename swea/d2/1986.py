# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PxmBqAe8DFAUq&categoryId=AV5PxmBqAe8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    sum = 0

    for i in range(1, n+1):
        if i % 2 == 0: # 짝수면 뺌
            sum -= i
        else: # 홀수면 더함
            sum += i

    print('#%d'%tc, sum)