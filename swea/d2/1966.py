# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PrmyKAWEDFAUq&categoryId=AV5PrmyKAWEDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1

for tc in range(1, t):
    n = int(input())
    nums = list(map(int, input().split()))
    nums.sort()
    print('#%d'%tc, end=' ')
    for num in nums:
        print(num, end=' ')
    print()