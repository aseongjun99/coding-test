# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QLkdKAz4DFAUq&categoryId=AV5QLkdKAz4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1

T = int(input()) + 1
for tc in range(1, T):
    date = input()
    year = date[:4]
    month = date[4:6]
    day = date[6:]
    _31 = [1, 3, 5, 7, 8, 10, 12]
    _30 = [4, 6, 9, 11]

    print('#%d'%tc, end=' ')
    if int(month) in _31 and int(day) <= 31:
        print(year, month, day, sep='/')
    elif int(month) in _30 and int(day) <= 30:
        print(year, month, day, sep='/')
    elif int(month) == 2 and int(day) <= 28:
        print(year, month, day, sep='/')
    else:
        print(-1)
