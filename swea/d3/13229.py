# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AX0SaDW6L2oDFASs&categoryId=AX0SaDW6L2oDFASs&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    s = input()
    day = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']

    idx = day.index(s)
    if 6 - idx == 0:
        print('#%d'%tc, 7)
    else:
        print('#%d'%tc, 6 - idx)
