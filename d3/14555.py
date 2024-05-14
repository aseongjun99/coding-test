# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYGtoa3qARcDFARC&categoryId=AYGtoa3qARcDFARC&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    grass = input()
    count = 0
    # () 를 먼저 찾는다.
    count += grass.count('()')
    grass = grass.split('()')

    # (과 )를 각각 찾는다.
    for g in grass:
        count += g.count('(')
        count += g.count(')')

    print('#%d'%tc, count)
