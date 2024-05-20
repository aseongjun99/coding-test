# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYJW0g-qlO8DFASv&categoryId=AYJW0g-qlO8DFASv&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    # 길이가 짝수면 alice가 이김
    if n % 2 == 0:
        print('#%d'%tc, 'Alice')
    else:
        print('#%d' % tc, 'Bob')

