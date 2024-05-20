# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1

N = int(input())
for i in range(1, N+1):
    count = 0
    temp = i
    for j in range(3):
        if temp % pow(10, j+1) in [3, 6, 9]:
            count += 1
        temp //= pow(10, j+1)

    if count == 0:
        print(i, end=' ')
    else:
        for j in range(count):
            print('-', end='')
        print(end=' ')
